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

	private void init() { // ���⼭�� �� ����� ũ�������� ����( ���� ��ġ�� ���� )
		this.setTitle("ȸ������");
		int tfSize = 10;

		Dimension lblSize = new Dimension(80, 35);
		Dimension btnSize = new Dimension(100, 25);

		Jtitle = new JLabel("ȸ�� ������ �Է��� �ּ���");
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

		jbtnJoin = new JButton("����");
		jbtnCancle = new JButton("���");

		jbtnJoin.setPreferredSize(btnSize);
		jbtnCancle.setPreferredSize(btnSize);

	}

	private void setDisplay() {
		FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT); // ���࿡ �����ϴ� ���̾ƿ�.
		JPanel pnlJoin = new JPanel(new BorderLayout()); // �̰� �������� ��ġ�Ұ���. ���߿� �̰� ���ʿ��ְ�,��ư�� ���ʿ� ��������.

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
//		JPanel pnlJSouth = new JPanel(new FlowLayout(FlowLayout.CENTER)); �ϴ� ��콺�� ���� ����
//		this.add(pnlMail)
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
//        this.setOpacity(0.5f); //���� ������ �����ӿ��� ������ �ִ�. �̰� ����ϸ� �̺�Ʈ�� �����ų�� ������ �߻���.

	}

	private void addListeners() {
		jbtnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���⿡ '���' ��ư�� ������ �� â�� �ݴ� �ڵ带 ���.
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jbtnCancle);
				frame.dispose(); // â �ݴ� �ڵ�
			}
		});
		jbtnJoin.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				if (isBlank()) { // isBlank �ż��尡 Ʈ���϶�.
					JOptionPane.showMessageDialog(Join.this, "��� ������ �Է����ּ���.");
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
			jtfName.requestFocus(); // ��������� ���⿡ ��Ŀ�� (ä������ �Ʒ����̵�)
			return true;
		}
		if (String.valueOf(jtfId.getText()).isEmpty()) { // ��������� ���⿡ ��Ŀ�� (ä������ �Ʒ����̵�)
			jtfId.requestFocus();
			return true;
		}
		if (String.valueOf(jtfPw.getText()).isEmpty()) { // ��������� ���⿡ ��Ŀ�� (ä������ �Ʒ����̵�)
			jtfPw.requestFocus();
			return true;
		}
		if (jtfEmail.getText().isEmpty()) { //��������� ���⿡ ��Ŀ�� (ä������ �Ʒ����̵�)
			jtfEmail.requestFocus();
			return true;
		}

		return result;
	}
	
	// Ȯ��â ����ִ� �ż���.
	public void joinConfirm() {
		JDialog dialog = new JDialog();
		dialog.setTitle("Ȯ��â");
		dialog.setSize(300, 150);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(null); // ȭ�� �߾ӿ� ��ġ
		JButton okButton = new JButton("Ȯ��");
		dialog.setLayout(new GridLayout(3, 3));
		//�׸��巹�̾ƿ��� ������� �־���� �� !!
		dialog.add(new JLabel(""));
		dialog.add(new JLabel("���ԵǾ����ϴ�."));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(new JLabel(""));
		dialog.add(okButton);
		// 5�� �Ŀ� ��ȭ ���� �ݱ�
		Timer timer = new Timer(5000, e -> dialog.dispose());
		timer.setRepeats(false);
		
		timer.start();
		
		dialog.setVisible(true);
		Join.this.dispose(); // ȸ������â�ݱ�

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 'Ȯ��' ��ư Ŭ�� �� ������ ����
				dialog.dispose(); // ���̾�α� �ݱ�
//                Join.this.dispose();
			}
		});
	}

}
