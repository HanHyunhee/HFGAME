package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;

public class LoginForm extends JPanel{
	MemberDAO mdao = new MemberDAO();
//	Frame frame = (Frame) SwingUtilities.getWindowAncestor(this);
	public Frame f = null; // 프레임자료형의 변수만 f로 선언해둠.
//	LoginedUser loguser = new LoginedUser();
	public JLabel lblId;
	public JLabel lblPw,titleLabel;
	public JTextField tfId;
	public JPasswordField tfPw;
	public JButton btnLogin;
	public JButton btnJoin;
	public JPanel titlepnl,pnlId,pnlPw,pnlSouth,pnlNorth;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 20);
	public LoginForm(Frame a) { //생성자에 프레임주소를 받아와서 위에서 변수만 선언한 f 에 loginForm 을 호출하는 Frame의 주소를 넣어줌.
		this.f = a;
		setDisplay();
		addListeners();
	}
	public void setDisplay() {
		this.setBorder(new BevelBorder(BevelBorder.RAISED)); // 요거 쓰면 앞에 튀어나오는것처럼 보여줌
		this.setLayout(new GridLayout(3,1));
		FlowLayout fleft = new FlowLayout(FlowLayout.LEFT); // 왼쪽정렬 : 플로우레이아웃 - 컴포넌트를 가로로 정렬하는 레이아웃매니저
		pnlNorth = new JPanel(new GridLayout(0, 1)); // 열 한개에 행이 가변적인 그리드레이아웃 객체 생성
		this.setOpaque(false);
		lblId = new JLabel("I  D          ");
		tfId = new JTextField(10);
		lblPw = new JLabel("Password");
		tfPw = new JPasswordField(10);
		btnLogin = new JButton("Login");
		btnJoin = new JButton("Join");
		titleLabel = new JLabel("로그인 화면");
		titleLabel.setFont(titleFont);
		titlepnl = new JPanel();
		titlepnl.setOpaque(false);
		titlepnl.add(titleLabel);
		

		lblId.setForeground(Color.white); 
		lblPw.setForeground(Color.white); 
		titleLabel.setForeground(Color.white);
		
		
		pnlId = new JPanel(fleft);
		pnlId.add(lblId);
		pnlId.add(tfId);
		pnlId.setOpaque(false);
		
		pnlPw = new JPanel(fleft);
		pnlPw.add(lblPw);
		pnlPw.add(tfPw);
		pnlPw.setOpaque(false);

		pnlNorth.add(pnlId);
		pnlNorth.add(pnlPw);
		pnlNorth.setOpaque(false);

		pnlSouth = new JPanel();
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnJoin);
		pnlSouth.setOpaque(false);

		pnlNorth.setBorder(new EmptyBorder(0, 10, 0, 10)); // 여백 주는 매서드
		pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		this.add(titlepnl);
		this.add(pnlNorth);
		this.add(pnlSouth);
		
	}
	private void addListeners() {
		
		btnJoin.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new Join();
		    }
		});
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = new String(tfId.getText());
				String pw = new String(tfPw.getPassword());
//				System.out.println(id); // 확인코드
//				System.out.println(pw); // 형변환 확인코드
				f.loguser.setLoginedUser(mdao.login(id,pw));//mdao.login(id,pw);
//				loginedUser = mdao.login(id,pw);
				System.out.println(mdao.login(id,pw));
				
				if(f.loguser.getLoginedUser() != null) {
		            f.loguser.setLoginState(true);
		            System.out.println("로그인 성공");
		            f.setLogId("로그인된 유저 : "+f.loguser.getLoginedUser(),true);
		            System.out.println(f.loguser.getLoginedUser());
		            LoginForm.this.setVisible(false);
		            f.logid.setVisible(true);
		            f.startbtn.setVisible(true);
//		            f.ccpnl.setVisible(true); // startbtn 으로 돌림
//		            f.desert.setVisible(true); // 로그인하면 스테이지1(사막맵)을 띄워줌.
				}else {
					System.out.println("로그인실패");
				}
				
				// DAO에 검색하는 매서드 만들어서 아이디 비밀번호 맞으면 로그인드유저 DB 에 아이디 넘겨주는 식을 써야함.
//				if 조건문으로 아이디 비번 맞는지 확인하는식이 트루이면 디비에 넘겨주게 코드 작성.
			}
		});
	}
}
