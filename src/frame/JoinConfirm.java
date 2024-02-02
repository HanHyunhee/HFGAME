package frame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class JoinConfirm extends JFrame{

	// �̰� �Ⱦ� . Joptionpane ������ !!!
	private JFrame frame;
	private Timer timer;

	public JoinConfirm() {
		        frame = new JFrame("ȸ������ �Ϸ�");
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setSize(300, 200);
		        frame.setLayout(new BorderLayout());

		        JLabel messageLabel = new JLabel("ȸ�����ԵǾ����ϴ�", SwingConstants.CENTER);
		        JButton okButton = new JButton("Ȯ��");

		        frame.add(messageLabel, BorderLayout.CENTER);
		        frame.add(okButton, BorderLayout.SOUTH);

		        // Ȯ�� ��ư �̺�Ʈ ó��
		        okButton.addActionListener(e -> closeFrame());

		        // 5�� �� �ڵ� ���Ḧ ���� Ÿ�̸�
		        timer = new Timer(5000, e -> closeFrame());
		        timer.setRepeats(false); // Ÿ�̸Ӱ� �� ���� ����ǵ��� ����
		        timer.start();

		        frame.setLocationRelativeTo(null); // ȭ�� �߾ӿ� ��ġ
		        frame.setVisible(true);
		    }

	private void closeFrame() {
		timer.stop(); // Ÿ�̸� ����
		frame.dispose(); // ������ �ݱ�
	}

	public static void main(String[] args) {
		// �׽�Ʈ�� ���� ���� �޼��忡 �߰�
		SwingUtilities.invokeLater(() -> new JoinConfirm());
	}

}
