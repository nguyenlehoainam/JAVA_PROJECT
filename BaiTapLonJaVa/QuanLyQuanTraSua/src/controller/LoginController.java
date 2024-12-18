package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.User;
import repository.UserRepositoryImpl;
import view.AdminView;
import view.ForgotPasswordView;
import view.LoginView;
import view.ProductView;
import view.SignUpView;

public class LoginController implements ActionListener {

    private LoginView loginView;
    private UserRepositoryImpl userRepository;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Login")) {
            handleLogin();
        } else if (command.equals("Forget Password ?")) {
            new ForgotPasswordView().setVisible(true);
            loginView.dispose();
        } else if (command.equals("SignUp")) {
            new SignUpView().setVisible(true);
            loginView.dispose();
        } else if (command.equals("Exit")) {
            System.exit(0);
        } else if (command.equals("Clear")) {
            loginView.xoaForm();
        }
    }

    private void handleLogin() {
        String email = loginView.getTextFieldEmail().getText();
        String password = new String(loginView.getPasswordField().getPassword());

        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            JOptionPane.showMessageDialog(loginView, "Đăng Nhập Thành Công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            if (user.getRole().equals("ADMIN")) {
                new AdminView().setVisible(true);
            } else {
                new ProductView().setVisible(true);
            }
            loginView.dispose();
        } else {
            JOptionPane.showMessageDialog(loginView, "Sai Email Hoặc Mật Khẩu!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
