package test;

import javax.swing.UIManager;

import model.User;
import view.ForgotPasswordView;
import view.ForgotPasswordView;

public class TestForgotPasswordView {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ForgotPasswordView();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
