package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import DAO.PlayerDAO;
import DTO.PlayerDTO;

public class CreateCharacterPanel extends JPanel {
	Frame f;
	PlayerDTO pdto = new PlayerDTO();
	PlayerDAO pdao = new PlayerDAO();
	JPanel question, answer;
	Font firstqFont = new Font("Times New Roman", Font.PLAIN, 40);
	Font nomalFont = new Font("Times New Roman", Font.PLAIN, 20);
	JLabel questionLabel, answer1;
	JTextField answerjtf;
//	JTextArea question;
	JButton createCharacterbtn, btnToStageOne;

	public CreateCharacterPanel(Frame a) {
		this.f = a;
		setpnl();
		question();
		addListeners();
	}

	private void setpnl() {

		this.setBounds(50, 35, 1000, 500);
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setVisible(false);
	}

	private void question() {
//		question = new JTextArea();
		question = new JPanel();
		question.setBounds(100, 120, 800, 80);
		question.setBackground(Color.black); // 나중에 블랙으로 바꾸셈
//		question.setLineWrap(true);
		questionLabel = new JLabel("케릭터의 이름을 정해 주세요.");
		questionLabel.setForeground(Color.white);
		questionLabel.setFont(firstqFont);
		question.add(questionLabel);

		answer = new JPanel(new GridLayout(1, 2));
		answer.setBounds(120, 320, 800, 40);
		answer.setBackground(Color.black);
		answerjtf = new JTextField("");
		answerjtf.setForeground(Color.white);
		answerjtf.setBackground(Color.LIGHT_GRAY);
		answerjtf.setFont(nomalFont);
		createCharacterbtn = new JButton("케릭터 생성");
		createCharacterbtn.setBackground(Color.yellow);
		createCharacterbtn.setBorderPainted(false);
		createCharacterbtn.setFont(nomalFont);

		answer.add(answerjtf);
		answer.add(createCharacterbtn);

		btnToStageOne = new JButton("스테이지1로");
		btnToStageOne.setBounds(850, 360, 130, 30);
		this.add(question);
		this.add(answer);
		this.add(btnToStageOne);
		btnToStageOne.setVisible(false);

	}

	private void addListeners() {
		createCharacterbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answer.setVisible(false);
				questionLabel.setText(answerjtf.getText() + " 으로 케릭터가 생성되었습니다");
				f.PlayerId = answerjtf.getText();
				pdto.setPlayerId(answerjtf.getText());
				pdto.setMemberId(f.loguser.getLoginedUser());
				System.out.println(f.loguser.getLoginedUser());
				pdao.insert(pdto);
				btnToStageOne.setVisible(true);

			}
		});
		btnToStageOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnToStageOne.setVisible(false);
				
				f.desert.setVisible(true);
			}

		});
	}
}
