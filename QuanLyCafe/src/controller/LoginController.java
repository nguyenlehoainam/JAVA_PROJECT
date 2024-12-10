package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginView;
import view.ForgotPasswordView;
import view.ProductView;
import view.AdminView;
import view.SignUpView;
import model.User;
import repository.UserRepositoryImpl;

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

        switch (command) {
            case "Login":
                handleLogin();
                break;
            case "Clear":
                handleClear();
                break;
            case "Forget Password ?":
                handleForgotPassword();
                break;
            case "Exit":
                handleExit();
                break;
            case "SignUp":
                handleSignUp();
                break;
            default:
                break;
        }
    }

    private void handleLogin() {
        try {
            String email = loginView.getTextFieldEmail().getText();
            char[] password = loginView.getPasswordField().getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(loginView, "Không Được Để Trống Gmail", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User user = userRepository.findByEmailAndPassword(email, new String(password));

            if (user != null) {
                if ("ADMIN".equals(user.getRole())) {
                    // Nếu là quản trị viên, chuyển sang AdminView
                    AdminView adminView = new AdminView();
                    adminView.setVisible(true);
                } else {
                    // Nếu là người dùng, chuyển sang ProductView
                    ProductView productView = new ProductView();
                    productView.setVisible(true);
                }
                loginView.dispose();
            } else {
                JOptionPane.showMessageDialog(loginView, "Sai Email hoặc Mật Khẩu", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Xảy Ra Lỗi Trong Quá Trình Đăng Nhập: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleClear() {
        loginView.getTextFieldEmail().setText("");
        loginView.getPasswordField().setText("");
    }

    private void handleForgotPassword() {
        new ForgotPasswordView().setVisible(true);
        loginView.dispose();
    }

    private void handleExit() {
        System.exit(0);
    }

    private void handleSignUp() {
        new SignUpView().setVisible(true);
        loginView.dispose();
    }
}
