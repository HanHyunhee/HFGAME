package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class Join extends JFrame {
	private Timer timer;
	MemberDAO mdao = new MemberDAO();
	String Id = null;
	public JLabel Jtitle;
	public JLabel jlblName;
	public JLabel jlblId;
	public JLabel jlblPw;
	public JLabel jlblEmail;

	public JTextField jtfName;
	public JTextField jtfId;
	public JTextField jtfPw;
	public JTextField jtfEmail;

	public JButton jbtnJoin;
	public JButton jbtnCancle;

	public Join() {
		init();
		setDisplay();
		showFrame();
		addListeners();
	}

	private void init() { // 여기서는 들어갈 내용과 크기정도를 지정( 아직 배치는 안함 )
		this.setTitle("회원가입");
		int tfSize = 10;

		Dimension lblSize = new Dimension(80, 35);
		Dimension btnSize = new Dimension(100, 25);

		Jtitle = new JLabel("회원 정보를 입력해 주세요");
		Jtitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

		jlblName = new JLabel("Name", JLabel.LEFT);
		jlblName.setPreferredSize(lblSize);
		jlblId = new JLabel("Id", JLabel.LEFT);
		jlblId.setPreferredSize(lblSize);
		jlblPw = new JLabel("PassWord", JLabel.LEFT);
		jlblPw.setPreferredSize(lblSize);
		jlblEmail = new JLabel("Email", JLabel.LEFT);
		;
		jlblEmail.setPreferredSize(lblSize);

		jtfName = new JTextField(tfSize);
		jtfId = new JTextField(tfSize);
		jtfPw = new JTextField(tfSize);
		jtfEmail = new JTextField(tfSize);

		jbtnJoin = new JButton("가입");
		jbtnCancle = new JButton("취소");

		jbtnJoin.setPreferredSize(btnSize);
		jbtnCancle.setPreferredSize(btnSize);

	}

	private void setDisplay() {
		FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT); // 한행에 정렬하는 레이아웃.
		JPanel pnlJoin = new JPanel(new BorderLayout()); // 이거 기준으로 배치할거임. 나중에 이걸 북쪽에넣고,버튼을 남쪽에 넣을거임.

		JPanel pnlJNorth = new JPanel(flowLeft);
		pnlJNorth.add(Jtitle);

		JPanel pnlJCenter = new JPanel(new GridLayout(0, 1));

		JPanel pnlName = new JPanel(flowLeft);
		pnlName.add(jlblName);
		pnlName.add(jtfName);

		JPanel pnlId = new JPanel(flowLeft);
		pnlId.add(jlblId);
		pnlId.add(jtfId);

		JPanel pnlPw = new JPanel(flowLeft);
		pnlPw.add(jlblPw);
		pnlPw.add(jtfPw);

		JPanel pnlMail = new JPanel(flowLeft);
		pnlMail.add(jlblEmail);
		pnlMail.add(jtfEmail);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(jbtnJoin);
		pnlSouth.add(jbtnCancle);

		pnlJCenter.add(pnlName);
		pnlJCenter.add(pnlId);
		pnlJCenter.add(pnlPw);
		pnlJCenter.add(pnlMail);

		this.add(pnlJCenter, BorderLayout.NORTH);
		this.add(pnlSouth, BorderLayout.SOUTH);
//		JPanel pnlJSouth = new JPanel(new FlowLayout(FlowLayout.CENTER)); 일단 사우스는 없이 진행
//		this.add(pnlMail)
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
//        this.setOpacity(0.5f); //투명도 설정은 프레임에는 제한이 있다. 이거 사용하면 이벤트로 종료시킬때 에러가 발생함.

	}

	private void addListeners() {
		jbtnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기에 '취소' 버튼을 눌렀을 때 창을 닫는 코드를 써요.
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jbtnCancle);
				frame.dispose(); // 창 닫는 코드
			}
		});
		jbtnJoin.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				if (isBlank()) { // isBlank 매서드가 트루일때.
					JOptionPane.showMessageDialog(Join.this, "모든 정보를 입력해주세요.");
				} else {
					MemberDTO a = new MemberDTO();
					String name = jtfName.getText();
					String id = jtfId.getText();
					String password = jtfPw.getText();
					String email = jtfEmail.getText();
					Boolean islogin = true;
					a.setName(name);
					a.setId(id);
					a.setPassword(password);
					a.setEmail(email);
					a.setIsLogin(islogin);
					mdao.insert(a);
					joinConfirm();

				}
			}

		});
	}

	public boolean isBlank() {
		boolean result = false;
		if (jtfName.getText().isEmpty()) {
			jtfName.requestFocus(); // 비어있으면 여기에 포커스 (채워지면 아래로이동)
			return true;
		}
		if (String.valueOf(jtfId.getText()).isEmpty()) { // 비어있으면 여기에 포커스 (채워지면 아래로이동)
			jtfId.requestFocus();
			return true;
		}
		if (String.valueOf(jtfPw.getText()).isEmpty()) { // 비어있으면 여기에 포커스 (채워지면 아래로이동)
			jtfPw.requestFocus();
			return true;
		}
		if (jtfEmail.getText().isEmpty()) { //비어있으면 여기에 포커스 (채워지면 아래로이동)
			jtfEmail.requestFocus();
			return true;
		}

		return result;
	}
	
	// 확인창 띄워주는 매서드.
	public void joinConfirm() {
		JDialog dialog = new JDialog();
		dialog.setTitle("확인창");
		dialog.setSize(300, 150);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(null); // 화면 중앙에 위치
		JButton okButton = new JButton("확인");
		dialog.setLayout(new GridLayout(3, 3));
		//그리드레이아웃은 순서대로 넣어줘야 됨 !!
		dialog.add(new JLabel(""));
		dialog.add(new JLabel("가입되었습니다."));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(okButton);
		// 5초 후에 대화 상자 닫기
		Timer timer = new Timer(5000, e -> dialog.dispose());
		timer.setRepeats(false);
		
		timer.start();
		
		dialog.setVisible(true);
		Join.this.dispose(); // 회원가입창닫기

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// '확인' 버튼 클릭 시 수행할 동작
				dialog.dispose(); // 다이어로그 닫기
//                Join.this.dispose();
			}
		});
	}

}
