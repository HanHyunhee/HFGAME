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
	public Frame f = null; // �������ڷ����� ������ f�� �����ص�.
//	LoginedUser loguser = new LoginedUser();
	public JLabel lblId;
	public JLabel lblPw,titleLabel;
	public JTextField tfId;
	public JPasswordField tfPw;
	public JButton btnLogin;
	public JButton btnJoin;
	public JPanel titlepnl,pnlId,pnlPw,pnlSouth,pnlNorth;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 20);
	public LoginForm(Frame a) { //�����ڿ� �������ּҸ� �޾ƿͼ� ������ ������ ������ f �� loginForm �� ȣ���ϴ� Frame�� �ּҸ� �־���.
		this.f = a;
		setDisplay();
		addListeners();
	}
	public void setDisplay() {
		this.setBorder(new BevelBorder(BevelBorder.RAISED)); // ��� ���� �տ� Ƣ����°�ó�� ������
		this.setLayout(new GridLayout(3,1));
		FlowLayout fleft = new FlowLayout(FlowLayout.LEFT); // �������� : �÷ο췹�̾ƿ� - ������Ʈ�� ���η� �����ϴ� ���̾ƿ��Ŵ���
		pnlNorth = new JPanel(new GridLayout(0, 1)); // �� �Ѱ��� ���� �������� �׸��巹�̾ƿ� ��ü ����
		this.setOpaque(false);
		lblId = new JLabel("I  D          ");
		tfId = new JTextField(10);
		lblPw = new JLabel("Password");
		tfPw = new JPasswordField(10);
		btnLogin = new JButton("Login");
		btnJoin = new JButton("Join");
		titleLabel = new JLabel("�α��� ȭ��");
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

		pnlNorth.setBorder(new EmptyBorder(0, 10, 0, 10)); // ���� �ִ� �ż���
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
//				System.out.println(id); // Ȯ���ڵ�
//				System.out.println(pw); // ����ȯ Ȯ���ڵ�
				f.loguser.setLoginedUser(mdao.login(id,pw));//mdao.login(id,pw);
//				loginedUser = mdao.login(id,pw);
				System.out.println(mdao.login(id,pw));
				
				if(f.loguser.getLoginedUser() != null) {
		            f.loguser.setLoginState(true);
		            System.out.println("�α��� ����");
		            f.setLogId("�α��ε� ���� : "+f.loguser.getLoginedUser(),true);
		            System.out.println(f.loguser.getLoginedUser());
		            LoginForm.this.setVisible(false);
		            f.logid.setVisible(true);
		            f.startbtn.setVisible(true);
//		            f.ccpnl.setVisible(true); // startbtn ���� ����
//		            f.desert.setVisible(true); // �α����ϸ� ��������1(�縷��)�� �����.
				}else {
					System.out.println("�α��ν���");
				}
				
				// DAO�� �˻��ϴ� �ż��� ���� ���̵� ��й�ȣ ������ �α��ε����� DB �� ���̵� �Ѱ��ִ� ���� �����.
//				if ���ǹ����� ���̵� ��� �´��� Ȯ���ϴ½��� Ʈ���̸� ��� �Ѱ��ְ� �ڵ� �ۼ�.
			}
		});
	}
}
