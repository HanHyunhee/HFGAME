package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import DAO.EnemyDAO;
import DAO.PlayerDAO;
import DTO.EnemyDTO;
import DTO.PlayerDTO;

public class MapOfDesert extends JPanel {
	PlayerDAO pdao = new PlayerDAO();
	PlayerDTO pdto = new PlayerDTO();
	EnemyDTO edto = new EnemyDTO();
	EnemyDAO edao = new EnemyDAO();

	Frame f = null;
	JPanel phpbarpnl, ehpbarpnl, textpnl, choiceList, choiceList2, choiceList3,choiceList4, showphp, showehp;
	JTextArea desertText;
	ImageIcon icon1, merchantIcon, milestoneIcon, standheroIcon, swingheroIcon, scorpionIcon;
	JButton btmerchant, btmilestone, btstandhero, btswinghero, btscorpion, btreadText, btAttack, btItem, btPassTurn,
			btEndGame,btEndGame2;
	JProgressBar phpbar, ehpbar;
	Font nomalFont = new Font("Times New Roman", Font.PLAIN, 20);
	JLabel showplayerhp, currentplayerhp, showenemyhp, currentenemyhp;
	int playerdamage, enemydamage;

	public MapOfDesert(Frame a) {
		this.f = a;
		this.setBounds(50, 35, 1000, 500);
		round1scol();
		setDesert();
		initDesert();
		text();
		battleCommand();
		afterCommand();
		JPaneOrder();
		addListeners();
	}

	private void initDesert() {
		setLayout(null);
		icon1 = new ImageIcon(".//res//desert.png");
		Image img1 = icon1.getImage();
		Image scaledImg1 = img1.getScaledInstance(1000, 500, Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(scaledImg1);
		this.setVisible(false);
		setOpaque(true);

	}

	private void setDesert() {
		merchantIcon = new ImageIcon(".//res//merchant.png"); // 이미지 파일 경로
		Image mimage = merchantIcon.getImage(); // ImageIcon을 Image로 변환
		Image scaledMimg = mimage.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH); // 이미지 크기 조정
		merchantIcon = new ImageIcon(scaledMimg); // 크기 조정된 Image를 다시 ImageIcon으로 변환

		btmerchant = new JButton(merchantIcon);
		btmerchant.setBounds(0, 150, 150, 200);
		btmerchant.setVisible(false);

		milestoneIcon = new ImageIcon(".//res//gotodesert.png"); // 이미지 파일 경로
		Image milestoneimg = milestoneIcon.getImage(); // ImageIcon을 Image로 변환
		Image scaledMSimg = milestoneimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// 이미지 크기 조정
		milestoneIcon = new ImageIcon(scaledMSimg); // 크기 조정된 Image를 다시 ImageIcon으로 변환

		btmilestone = new JButton(milestoneIcon);
		btmilestone.setContentAreaFilled(false); // 버튼의 콘텐츠 영역 배경을 투명하게 설정
		btmilestone.setBorderPainted(false); // 버튼의 테두리를 그리지 않음
		btmilestone.setBounds(850, 150, 160, 220);
		btmilestone.setVisible(false);

		standheroIcon = new ImageIcon(".//res//standhero.png"); // 이미지 파일 경로
		Image standheroimg = standheroIcon.getImage(); // ImageIcon을 Image로 변환
		Image scaledSTHimg = standheroimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// 이미지 크기 조정
		standheroIcon = new ImageIcon(scaledSTHimg); // 크기 조정된 Image를 다시 ImageIcon으로 변환

		btstandhero = new JButton(standheroIcon);
		btstandhero.setContentAreaFilled(false); // 버튼의 콘텐츠 영역 배경을 투명하게 설정
		btstandhero.setBorderPainted(false); // 버튼의 테두리를 그리지 않음
		btstandhero.setBounds(240, 250, 160, 220);
		// 테스팅할때 잠깐 true
		btstandhero.setVisible(false);

		swingheroIcon = new ImageIcon(".//res//swinghero.png"); // 이미지 파일 경로
		Image swingheroimg = swingheroIcon.getImage(); // ImageIcon을 Image로 변환
		Image scaledSWHimg = swingheroimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// 이미지 크기 조정
		swingheroIcon = new ImageIcon(scaledSWHimg); // 크기 조정된 Image를 다시 ImageIcon으로 변환

		btswinghero = new JButton(swingheroIcon);
		btswinghero.setContentAreaFilled(false); // 버튼의 콘텐츠 영역 배경을 투명하게 설정
		btswinghero.setBorderPainted(false); // 버튼의 테두리를 그리지 않음
		btswinghero.setBounds(240, 250, 160, 220);
		btswinghero.setVisible(false);

		scorpionIcon = new ImageIcon(".//res//standscorpion.png"); // 이미지 파일 경로
		Image scorpionimg = scorpionIcon.getImage(); // ImageIcon을 Image로 변환
		Image scaledscpimg = scorpionimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// 이미지 크기 조정
		scorpionIcon = new ImageIcon(scaledscpimg); // 크기 조정된 Image를 다시 ImageIcon으로 변환

		btscorpion = new JButton(scorpionIcon);
		btscorpion.setContentAreaFilled(false); // 버튼의 콘텐츠 영역 배경을 투명하게 설정
		btscorpion.setBorderPainted(false); // 버튼의 테두리를 그리지 않음
		btscorpion.setBounds(550, 250, 160, 220);
		// teseting true
		btscorpion.setVisible(false);
		
		// 플레이어 체력 바
		phpbarpnl = new JPanel();
		phpbarpnl.setBounds(210, 460, 200, 30);
		phpbarpnl.setOpaque(false);
		phpbarpnl.setVisible(false);
		// 0 ~ 케릭터 최대 HP
		phpbar = new JProgressBar(0, pdto.getMaxHP()); 
		phpbar.setValue(pdto.getHP());
		phpbar.setPreferredSize(new Dimension(200, 30));
		phpbar.setForeground(Color.green);
		phpbar.setBackground(Color.red);
		phpbarpnl.add(phpbar);
		
		// 적의 체력 바
		ehpbarpnl = new JPanel();
		ehpbarpnl.setBounds(510, 460, 200, 30);
		ehpbarpnl.setOpaque(false);
		ehpbarpnl.setVisible(false);
		// 0 ~ 몬스터 최대 HP
		
		ehpbar = new JProgressBar(0, edto.getMaxHP()); 
		ehpbar.setValue(edto.getHP());
		ehpbar.setPreferredSize(new Dimension(200, 30));
		ehpbar.setForeground(Color.green);
		ehpbar.setBackground(Color.red);
		ehpbarpnl.add(ehpbar);

		showphp = new JPanel(new GridLayout(1, 2));
		showphp.setBounds(240, 200, 100, 30);
		showphp.setBackground(Color.BLUE);
		showphp.setOpaque(false);
		showphp.setVisible(true);
		showplayerhp = new JLabel("H P");
		showplayerhp.setFont(nomalFont);

		// 형변환
		currentplayerhp = new JLabel(String.valueOf(pdto.getHP()));
		currentplayerhp.setFont(nomalFont);
		showphp.add(showplayerhp);
		showphp.add(currentplayerhp);

		showehp = new JPanel();
		showehp = new JPanel(new GridLayout(1, 2));
		showehp.setBounds(510, 200, 100, 30);
		showehp.setBackground(Color.BLUE);
		showehp.setOpaque(false);
		showehp.setVisible(true);
		showenemyhp = new JLabel("H P");
		showenemyhp.setFont(nomalFont);

		// 형변환
		currentenemyhp = new JLabel(String.valueOf(edto.getHP()));
		currentenemyhp.setFont(nomalFont);
		showehp.add(showenemyhp);
		showehp.add(currentenemyhp);

		showphp.setVisible(false);
		showehp.setVisible(false);
	}

	private void text() {
		textpnl = new JPanel();
		textpnl.setVisible(true);
		textpnl.setBounds(250, 150, 600, 220);
		textpnl.setOpaque(false);

		desertText = new JTextArea("마을에 오신걸 환영합니다. 왼쪽의 상인을 클릭하면 상점을 이용할 수 있고, 오른쪽의 이정표를 클릭하면 마을 밖으로 이동할 수 있습니다.");
		desertText.setForeground(Color.black);
		desertText.setBounds(250, 150, 600, 220);
		desertText.setLineWrap(true);
		desertText.setFont(nomalFont);
		desertText.setOpaque(false);

		textpnl.add(desertText);

		btreadText = new JButton("Enter");
		btreadText.setFont(nomalFont);
		btreadText.setForeground(Color.red);
		btreadText.setBackground(Color.green);
		btreadText.setBorder(new BevelBorder(BevelBorder.RAISED));
		btreadText.setVisible(true);
		btreadText.setBounds(800, 220, 200, 200);

		this.add(btreadText);
		this.add(textpnl);
	}

	private void battleCommand() {
		choiceList = new JPanel(new GridLayout(2, 1));

		choiceList.setBounds(400, 250, 100, 70);
		btAttack = new JButton("Attack");
		btAttack.setBackground(Color.blue);
		btAttack.setForeground(Color.red);
		btAttack.setFocusPainted(false);
		btAttack.setActionCommand("c1");
//		choice1.addActionListener(choiceHandler);

		btItem = new JButton("Item");
		btItem.setBackground(Color.blue);
		btItem.setForeground(Color.red);
		btItem.setFocusPainted(false);
		btAttack.setActionCommand("c2");
		choiceList.add(btAttack);
		choiceList.add(btItem);
		choiceList.setVisible(false);

		this.add(choiceList);
	}

	private void afterCommand() {
		choiceList2 = new JPanel(new GridLayout(1, 1));

		choiceList2.setBounds(400, 250, 120, 35);
		btPassTurn = new JButton("Enemy Turn");
		btPassTurn.setBackground(Color.blue);
		btPassTurn.setForeground(Color.red);
		btPassTurn.setFocusPainted(false);
//		btPassTurn.setActionCommand("c2");
		choiceList2.add(btPassTurn);
		choiceList2.setVisible(false);

		this.add(choiceList2);

		choiceList3 = new JPanel(new GridLayout(1, 1));

		choiceList3.setBounds(400, 250, 120, 35);
		btEndGame = new JButton("EndGame");
		btEndGame.setBackground(Color.blue);
		btEndGame.setForeground(Color.red);
		btEndGame.setFocusPainted(false);
//		btPassTurn.setActionCommand("c3");
		choiceList3.add(btEndGame);
		choiceList3.setVisible(false);
		
		choiceList4 = new JPanel(new GridLayout(1, 1));

		choiceList4.setBounds(400, 250, 120, 35);
		btEndGame2 = new JButton("DeadEnd");
		btEndGame2.setBackground(Color.blue);
		btEndGame2.setForeground(Color.red);
		btEndGame2.setFocusPainted(false);
//		btPassTurn.setActionCommand("c3");
		choiceList4.add(btEndGame2);
		choiceList4.setVisible(false);

		this.add(choiceList3);
		this.add(choiceList4);
	}

	private void JPaneOrder() {
		// 맵안에 케릭터 등의 앞뒤 순서정해주는 코드
		JLayeredPane desertpane = new JLayeredPane();
		desertpane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(desertpane);
		desertpane.add(btmerchant, Integer.valueOf(10));
		desertpane.add(btmilestone, Integer.valueOf(11));
		desertpane.add(btstandhero, Integer.valueOf(11));
		desertpane.add(btswinghero, Integer.valueOf(11));
		desertpane.add(btscorpion, Integer.valueOf(12));
		desertpane.add(phpbarpnl, Integer.valueOf(11));
		desertpane.add(ehpbarpnl, Integer.valueOf(11));
		desertpane.add(showphp, Integer.valueOf(11));
		desertpane.add(showehp, Integer.valueOf(11));

	}

	private void round1scol() {
		pdto.setPlayerId(f.PlayerId);
		edto = edao.getEnemy("scorpion");
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(icon1.getImage(), 0, 0, null);
//		g.drawImage(merchantIcon.getImage(), 0, 100, null);
		setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}

	private void addListeners() {

		btmerchant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 상점여는 매서드호출.
				desertText.setText("전갈들이 내 물건을 모두 빼앗아가서 남은게 없네..");
				desertText.setVisible(true);
				
				Timer timer = new Timer(2500, evt -> desertText.setVisible(false));
				timer.setRepeats(false);
				
				timer.start();
			}
		});
		btmilestone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				round1scol();
				ehpbarpnl.setVisible(true);
				choiceList.setVisible(true);
				btmilestone.setVisible(false);
//				f.desert.btmerchant.setVisible(false);
				btmerchant.setVisible(false);
//				f.desert.btstandhero.setVisible(true);
				btstandhero.setVisible(true);
				f.desert.btscorpion.setVisible(true);
				btscorpion.setVisible(true);
				phpbarpnl.setVisible(true);
				showphp.setVisible(true);
				showehp.setVisible(true);
				desertText.setText("야생의"+edto.getEnemyId()+" 가 나타났다!!");
				desertText.setVisible(true);
				
			}
		});
		btreadText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desertText.setVisible(false);
				btreadText.setVisible(false);
				btmerchant.setVisible(true);
				btmilestone.setVisible(true);
			}
		});
		btAttack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerAttack();
				// 플레이어가 몬스터 공격한 내용 넣고 버튼 사라지게함.
				
				// 버튼 없애고 , 다른 버튼 띄워주는 코드.
				// 조건문 사용해서 enemy hp가 > 1 일 경우 다른 화면이 나오도록 코드작성.
				if(edto.getHP()<1) {
					//기존의 버튼 삭제
					choiceList.setVisible(false);
					desertText.setText("당신은 "+edto.getEnemyId()+" 를 물리쳤습니다.!!");
					choiceList3.setVisible(true);
				}else {
					choiceList.setVisible(false);
					choiceList2.setVisible(true);					
				}
			}
		});
		
		btPassTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enemyAttack();
				// 몬스터가 플레이어 공격한 내용 넣고 버튼 사라져!
				desertText.setText(edto.getEnemyId()+" 가"+pdto.getPlayerId()+" 를 공격하여"+enemydamage+" 의 피해를 주었습니다.");
				// 버튼없애고 플레이어턴으로 가자
				// 조건문 사용해서 플레이어의 hp가 > 1 일 경우 다른 화면이 나오도록 코드작성.
				if(pdto.getHP()<1) {
					choiceList2.setVisible(false);
					desertText.setText("당신은 "+edto.getEnemyId()+" 에게 패배하였습니다!!");
					choiceList4.setVisible(true);
				}else {
					choiceList2.setVisible(false);
					choiceList.setVisible(true);					
				}
//				
			}
		});
		
		btEndGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 이미지 frame의 배경이미지 바꾸고, layeredpane 순서 바꾸기.
				f.setEndBackground(".//res//win.png");
			}
		});
		btEndGame2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 이미지 frame의 배경이미지 바꾸고, layeredpane 순서 바꾸기.
				
				f.setEndBackground(".//res//defeat.png");
			}
		});
		btItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
	}

	private void playerAttack() {
		playerdamage = new java.util.Random().nextInt(pdto.getATK()) + 1 - edto.getDEF();
		edto.setHP(edto.getHP() - playerdamage);
		// 인트를 스트링으로 바꿔야 하므로 형변환 해줘야함.
		
		btstandhero.setVisible(false);
		btswinghero.setVisible(true);
		btscorpion.setBounds(550, 235, 160, 220);
		currentenemyhp.setText(String.valueOf(edto.getHP()));
		ehpbar.setValue(edto.getHP());
		Timer timer = new Timer(500, atkevt -> {
			btswinghero.setVisible(false);
			btstandhero.setVisible(true);
			btscorpion.setBounds(550, 250, 160, 220);
			
		});
		timer.setRepeats(false);
		timer.start();
		desertText.setText(pdto.getPlayerId()+" 가"+edto.getEnemyId()+" 를 공격하여"+playerdamage+" 의 피해를 주었습니다.");
		
		
	}

	private void enemyAttack() {
		enemydamage = new java.util.Random().nextInt(edto.getATK()) + 1 - pdto.getDEF();
		pdto.setHP(pdto.getHP() - enemydamage);
		btscorpion.setBounds(240, 250, 160, 220);
		btstandhero.setBounds(225, 240, 160, 220);
		currentplayerhp.setText(String.valueOf(pdto.getHP()));
		Timer timer = new Timer(500, eatkevt -> {
			btstandhero.setBounds(240, 250, 160, 220);
			btscorpion.setBounds(550, 250, 160, 220);
		});
		timer.setRepeats(false);
		timer.start();
		btscorpion.setBounds(550, 250, 160, 220);
		btstandhero.setBounds(240, 250, 160, 220);
		phpbar.setValue(pdto.getHP());
	}

}
