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
		merchantIcon = new ImageIcon(".//res//merchant.png"); // �̹��� ���� ���
		Image mimage = merchantIcon.getImage(); // ImageIcon�� Image�� ��ȯ
		Image scaledMimg = mimage.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH); // �̹��� ũ�� ����
		merchantIcon = new ImageIcon(scaledMimg); // ũ�� ������ Image�� �ٽ� ImageIcon���� ��ȯ

		btmerchant = new JButton(merchantIcon);
		btmerchant.setBounds(0, 150, 150, 200);
		btmerchant.setVisible(false);

		milestoneIcon = new ImageIcon(".//res//gotodesert.png"); // �̹��� ���� ���
		Image milestoneimg = milestoneIcon.getImage(); // ImageIcon�� Image�� ��ȯ
		Image scaledMSimg = milestoneimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// �̹��� ũ�� ����
		milestoneIcon = new ImageIcon(scaledMSimg); // ũ�� ������ Image�� �ٽ� ImageIcon���� ��ȯ

		btmilestone = new JButton(milestoneIcon);
		btmilestone.setContentAreaFilled(false); // ��ư�� ������ ���� ����� �����ϰ� ����
		btmilestone.setBorderPainted(false); // ��ư�� �׵θ��� �׸��� ����
		btmilestone.setBounds(850, 150, 160, 220);
		btmilestone.setVisible(false);

		standheroIcon = new ImageIcon(".//res//standhero.png"); // �̹��� ���� ���
		Image standheroimg = standheroIcon.getImage(); // ImageIcon�� Image�� ��ȯ
		Image scaledSTHimg = standheroimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// �̹��� ũ�� ����
		standheroIcon = new ImageIcon(scaledSTHimg); // ũ�� ������ Image�� �ٽ� ImageIcon���� ��ȯ

		btstandhero = new JButton(standheroIcon);
		btstandhero.setContentAreaFilled(false); // ��ư�� ������ ���� ����� �����ϰ� ����
		btstandhero.setBorderPainted(false); // ��ư�� �׵θ��� �׸��� ����
		btstandhero.setBounds(240, 250, 160, 220);
		// �׽����Ҷ� ��� true
		btstandhero.setVisible(false);

		swingheroIcon = new ImageIcon(".//res//swinghero.png"); // �̹��� ���� ���
		Image swingheroimg = swingheroIcon.getImage(); // ImageIcon�� Image�� ��ȯ
		Image scaledSWHimg = swingheroimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// �̹��� ũ�� ����
		swingheroIcon = new ImageIcon(scaledSWHimg); // ũ�� ������ Image�� �ٽ� ImageIcon���� ��ȯ

		btswinghero = new JButton(swingheroIcon);
		btswinghero.setContentAreaFilled(false); // ��ư�� ������ ���� ����� �����ϰ� ����
		btswinghero.setBorderPainted(false); // ��ư�� �׵θ��� �׸��� ����
		btswinghero.setBounds(240, 250, 160, 220);
		btswinghero.setVisible(false);

		scorpionIcon = new ImageIcon(".//res//standscorpion.png"); // �̹��� ���� ���
		Image scorpionimg = scorpionIcon.getImage(); // ImageIcon�� Image�� ��ȯ
		Image scaledscpimg = scorpionimg.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);// �̹��� ũ�� ����
		scorpionIcon = new ImageIcon(scaledscpimg); // ũ�� ������ Image�� �ٽ� ImageIcon���� ��ȯ

		btscorpion = new JButton(scorpionIcon);
		btscorpion.setContentAreaFilled(false); // ��ư�� ������ ���� ����� �����ϰ� ����
		btscorpion.setBorderPainted(false); // ��ư�� �׵θ��� �׸��� ����
		btscorpion.setBounds(550, 250, 160, 220);
		// teseting true
		btscorpion.setVisible(false);
		
		// �÷��̾� ü�� ��
		phpbarpnl = new JPanel();
		phpbarpnl.setBounds(210, 460, 200, 30);
		phpbarpnl.setOpaque(false);
		phpbarpnl.setVisible(false);
		// 0 ~ �ɸ��� �ִ� HP
		phpbar = new JProgressBar(0, pdto.getMaxHP()); 
		phpbar.setValue(pdto.getHP());
		phpbar.setPreferredSize(new Dimension(200, 30));
		phpbar.setForeground(Color.green);
		phpbar.setBackground(Color.red);
		phpbarpnl.add(phpbar);
		
		// ���� ü�� ��
		ehpbarpnl = new JPanel();
		ehpbarpnl.setBounds(510, 460, 200, 30);
		ehpbarpnl.setOpaque(false);
		ehpbarpnl.setVisible(false);
		// 0 ~ ���� �ִ� HP
		
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

		// ����ȯ
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

		// ����ȯ
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

		desertText = new JTextArea("������ ���Ű� ȯ���մϴ�. ������ ������ Ŭ���ϸ� ������ �̿��� �� �ְ�, �������� ����ǥ�� Ŭ���ϸ� ���� ������ �̵��� �� �ֽ��ϴ�.");
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
		// �ʾȿ� �ɸ��� ���� �յ� ���������ִ� �ڵ�
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
		setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
		super.paintComponent(g);
	}

	private void addListeners() {

		btmerchant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �������� �ż���ȣ��.
				desertText.setText("�������� �� ������ ��� ���Ѿư��� ������ ����..");
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
				desertText.setText("�߻���"+edto.getEnemyId()+" �� ��Ÿ����!!");
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
				// �÷��̾ ���� ������ ���� �ְ� ��ư ���������.
				
				// ��ư ���ְ� , �ٸ� ��ư ����ִ� �ڵ�.
				// ���ǹ� ����ؼ� enemy hp�� > 1 �� ��� �ٸ� ȭ���� �������� �ڵ��ۼ�.
				if(edto.getHP()<1) {
					//������ ��ư ����
					choiceList.setVisible(false);
					desertText.setText("����� "+edto.getEnemyId()+" �� �����ƽ��ϴ�.!!");
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
				// ���Ͱ� �÷��̾� ������ ���� �ְ� ��ư �����!
				desertText.setText(edto.getEnemyId()+" ��"+pdto.getPlayerId()+" �� �����Ͽ�"+enemydamage+" �� ���ظ� �־����ϴ�.");
				// ��ư���ְ� �÷��̾������� ����
				// ���ǹ� ����ؼ� �÷��̾��� hp�� > 1 �� ��� �ٸ� ȭ���� �������� �ڵ��ۼ�.
				if(pdto.getHP()<1) {
					choiceList2.setVisible(false);
					desertText.setText("����� "+edto.getEnemyId()+" ���� �й��Ͽ����ϴ�!!");
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
				// �̹��� frame�� ����̹��� �ٲٰ�, layeredpane ���� �ٲٱ�.
				f.setEndBackground(".//res//win.png");
			}
		});
		btEndGame2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �̹��� frame�� ����̹��� �ٲٰ�, layeredpane ���� �ٲٱ�.
				
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
		// ��Ʈ�� ��Ʈ������ �ٲ�� �ϹǷ� ����ȯ �������.
		
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
		desertText.setText(pdto.getPlayerId()+" ��"+edto.getEnemyId()+" �� �����Ͽ�"+playerdamage+" �� ���ظ� �־����ϴ�.");
		
		
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
