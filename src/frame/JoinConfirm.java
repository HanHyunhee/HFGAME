package frame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class JoinConfirm extends JFrame{

	// 이거 안씀 . Joptionpane 쓸거임 !!!
	private JFrame frame;
	private Timer timer;

	public JoinConfirm() {
		        frame = new JFrame("회원가입 완료");
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setSize(300, 200);
		        frame.setLayout(new BorderLayout());

		        JLabel messageLabel = new JLabel("회원가입되었습니다", SwingConstants.CENTER);
		        JButton okButton = new JButton("확인");

		        frame.add(messageLabel, BorderLayout.CENTER);
		        frame.add(okButton, BorderLayout.SOUTH);

		        // 확인 버튼 이벤트 처리
		        okButton.addActionListener(e -> closeFrame());

		        // 5초 후 자동 종료를 위한 타이머
		        timer = new Timer(5000, e -> closeFrame());
		        timer.setRepeats(false); // 타이머가 한 번만 실행되도록 설정
		        timer.start();

		        frame.setLocationRelativeTo(null); // 화면 중앙에 위치
		        frame.setVisible(true);
		    }

	private void closeFrame() {
		timer.stop(); // 타이머 중지
		frame.dispose(); // 프레임 닫기
	}

	public static void main(String[] args) {
		// 테스트를 위해 메인 메서드에 추가
		SwingUtilities.invokeLater(() -> new JoinConfirm());
	}

}
