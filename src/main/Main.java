package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import frame.Frame;

public class Main {

	public static void main(String[] args) {
		UImanager();
		new Frame();
	}
	// �̰� ����� ��ư�� ���� ��.
	static void UImanager() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}