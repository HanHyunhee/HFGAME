package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class Frame extends JFrame {
	String PlayerId;
	String Logineduser;
	ImageIcon winIcon;
	LoginedUser loguser = new LoginedUser();
	JPanel login = new LoginForm(this);
	JButton startbtn = new JButton("START GAME");
	MapOfDesert desert = new MapOfDesert(this);
	CreateCharacterPanel ccpnl = new CreateCharacterPanel(this);
	ImageIcon icon;
	Font startFont = new Font("Times New Roman", Font.PLAIN, 30);
	// 스테이지별 클리어 상태 관리변수.
	boolean clearS1 = false;
//	Thread gameThread;

	JLabel a = new JLabel("로그인된 유저 : 없음");
	JPanel logid = new JPanel(); // 로그인한 유저명 jtextfield 를 패널안에 담아주기위한 패널.

	public Frame() {
		DAO.DAO.driverLoad(); //
		SwingUtilities.invokeLater(() -> { // 요거 해줘야 jpanel paintComponent 매서드 사용 가능.
			initUI();
			addListeners();
//			setEndBackground(".//res//win.png"); // 엔딩분기 확인용1
//			setEndBackground(".//res//defeat.png"); // 엔딩분기 확인용2
			// 스테이별 테스트용 비전(마지막에 삭제할것)
//			desert.setVisible(true); 
		});
	}

	public void setLogId(String id, boolean a) { // 프레임 매서드
		this.a.setText(id);
		this.a.setVisible(a);
	}
	public void setEndBackground(String a) {

		winIcon = new ImageIcon(a);
		Image img = winIcon.getImage();
		Image scaledImg = img.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);
		winIcon = new ImageIcon(scaledImg);

		JPanel winBackground = new JPanel() {
	        @Override
	        public void paintComponent(Graphics g) {
	            g.drawImage(winIcon.getImage(), 0, 0, null);
	            setOpaque(false);
	            super.paintComponent(g);
	        }
	    };
	    winBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
	    // 여기서 layeredPane을 가져오고, 기존 배경을 제거 후 새 배경을 추가합니다.
	    JLayeredPane layeredPane = getLayeredPane();
	    layeredPane.removeAll(); // 기존 컴포넌트 제거
	    layeredPane.add(winBackground, Integer.valueOf(0)); // 새 배경 추가
	    layeredPane.revalidate(); // 컨테이너 다시 그리기
	    layeredPane.repaint(); // 컨테이너 다시 그리기
	}
	
	private void initUI() {
		// TODO Auto-generated method stub
		this.setTitle("HFGame");
		this.setSize(1100, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // 화면정중앙에 실행시켜주세요 라는 의미!
		this.setVisible(true);
		// 스타트 버튼 세팅
		startbtn.setBounds(440, 270, 250, 50);
		startbtn.setVisible(false);
		startbtn.setFont(startFont);
		startbtn.setForeground(Color.RED);
		startbtn.setContentAreaFilled(false); // 버튼의 콘텐츠 영역 배경을 투명하게 설정
		startbtn.setBorderPainted(false); // 버튼의 테두리를 그리지 않음

		int frameWidth = this.getWidth();
		int frameHeight = this.getHeight();
		int loginWidth = 300;
		int loginHeight = 200;
		// 로그인 패널의 x 좌표는 프레임 너비에서 로그인 패널 너비를 뺀 값
		int loginX = frameWidth - loginWidth;
		// 로그인 패널의 y 좌표는 적당히 설정 (예: 상단으로부터 200 픽셀)
		int loginY = 200;
		
		a.setForeground(Color.WHITE);
		logid.add(a);
		logid.setBorder(new BevelBorder(BevelBorder.RAISED));
		logid.setBounds(loginX+95, loginY - 195, 200, 30);
		logid.setOpaque(false);
		
		logid.setVisible(false);
		
		login.setBounds(loginX, loginY, loginWidth, loginHeight);
		// 이미지 관련 코드
		icon = new ImageIcon(".//res//background.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImg);

		JPanel background = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
				
			}
		};
		
		
		// 레이어페인 : 여러개의 컴포넌트가 겹쳐질때 우선순위를정해서 높은게 앞으로 나온것처럼 보이게 만들어줌.
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(layeredPane);

		background.setBounds(0, 0, this.getWidth(), this.getHeight());

		// 레이어 페인
		layeredPane.add(background, Integer.valueOf(0)); // 배경은 낮은 레이어
		layeredPane.add(login, Integer.valueOf(7)); // 로그인 패널은 높은 레이어
		layeredPane.add(logid, Integer.valueOf(8)); // 로그인된 유저 나타내는 텍스트필드는 더높은 레이어
		layeredPane.add(desert, Integer.valueOf(9));
		layeredPane.add(ccpnl, Integer.valueOf(9));
		layeredPane.add(startbtn, Integer.valueOf(9));
	}
	
	
	private void addListeners() {

		startbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ccpnl.setVisible(true);
//				f.desert.setVisible(true); // 로그인하면 스테이지1(사막맵)을 띄워줌.

			}
		});
	}
}
