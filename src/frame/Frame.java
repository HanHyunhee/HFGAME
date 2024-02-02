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
	// ���������� Ŭ���� ���� ��������.
	boolean clearS1 = false;
//	Thread gameThread;

	JLabel a = new JLabel("�α��ε� ���� : ����");
	JPanel logid = new JPanel(); // �α����� ������ jtextfield �� �гξȿ� ����ֱ����� �г�.

	public Frame() {
		DAO.DAO.driverLoad(); //
		SwingUtilities.invokeLater(() -> { // ��� ����� jpanel paintComponent �ż��� ��� ����.
			initUI();
			addListeners();
//			setEndBackground(".//res//win.png"); // �����б� Ȯ�ο�1
//			setEndBackground(".//res//defeat.png"); // �����б� Ȯ�ο�2
			// �����̺� �׽�Ʈ�� ����(�������� �����Ұ�)
//			desert.setVisible(true); 
		});
	}

	public void setLogId(String id, boolean a) { // ������ �ż���
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
	    // ���⼭ layeredPane�� ��������, ���� ����� ���� �� �� ����� �߰��մϴ�.
	    JLayeredPane layeredPane = getLayeredPane();
	    layeredPane.removeAll(); // ���� ������Ʈ ����
	    layeredPane.add(winBackground, Integer.valueOf(0)); // �� ��� �߰�
	    layeredPane.revalidate(); // �����̳� �ٽ� �׸���
	    layeredPane.repaint(); // �����̳� �ٽ� �׸���
	}
	
	private void initUI() {
		// TODO Auto-generated method stub
		this.setTitle("HFGame");
		this.setSize(1100, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // ȭ�����߾ӿ� ��������ּ��� ��� �ǹ�!
		this.setVisible(true);
		// ��ŸƮ ��ư ����
		startbtn.setBounds(440, 270, 250, 50);
		startbtn.setVisible(false);
		startbtn.setFont(startFont);
		startbtn.setForeground(Color.RED);
		startbtn.setContentAreaFilled(false); // ��ư�� ������ ���� ����� �����ϰ� ����
		startbtn.setBorderPainted(false); // ��ư�� �׵θ��� �׸��� ����

		int frameWidth = this.getWidth();
		int frameHeight = this.getHeight();
		int loginWidth = 300;
		int loginHeight = 200;
		// �α��� �г��� x ��ǥ�� ������ �ʺ񿡼� �α��� �г� �ʺ� �� ��
		int loginX = frameWidth - loginWidth;
		// �α��� �г��� y ��ǥ�� ������ ���� (��: ������κ��� 200 �ȼ�)
		int loginY = 200;
		
		a.setForeground(Color.WHITE);
		logid.add(a);
		logid.setBorder(new BevelBorder(BevelBorder.RAISED));
		logid.setBounds(loginX+95, loginY - 195, 200, 30);
		logid.setOpaque(false);
		
		logid.setVisible(false);
		
		login.setBounds(loginX, loginY, loginWidth, loginHeight);
		// �̹��� ���� �ڵ�
		icon = new ImageIcon(".//res//background.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1100, 600, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImg);

		JPanel background = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
				
			}
		};
		
		
		// ���̾����� : �������� ������Ʈ�� �������� �켱���������ؼ� ������ ������ ���°�ó�� ���̰� �������.
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(layeredPane);

		background.setBounds(0, 0, this.getWidth(), this.getHeight());

		// ���̾� ����
		layeredPane.add(background, Integer.valueOf(0)); // ����� ���� ���̾�
		layeredPane.add(login, Integer.valueOf(7)); // �α��� �г��� ���� ���̾�
		layeredPane.add(logid, Integer.valueOf(8)); // �α��ε� ���� ��Ÿ���� �ؽ�Ʈ�ʵ�� ������ ���̾�
		layeredPane.add(desert, Integer.valueOf(9));
		layeredPane.add(ccpnl, Integer.valueOf(9));
		layeredPane.add(startbtn, Integer.valueOf(9));
	}
	
	
	private void addListeners() {

		startbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ccpnl.setVisible(true);
//				f.desert.setVisible(true); // �α����ϸ� ��������1(�縷��)�� �����.

			}
		});
	}
}
