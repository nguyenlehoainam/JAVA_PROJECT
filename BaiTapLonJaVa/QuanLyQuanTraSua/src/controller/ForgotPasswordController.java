package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.List;
import model.User;
import view.ForgotPasswordView;
import repository.UserRepositoryImpl;

public class ForgotPasswordController implements ActionListener {

    private ForgotPasswordView forgotPasswordView;
    private UserRepositoryImpl userRepository;

    public ForgotPasswordController(ForgotPasswordView forgotPasswordView) {
        this.forgotPasswordView = forgotPasswordView;
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Find")) {
            handleFindUser();
        }
    }

    private void handleFindUser() {
        String email = forgotPasswordView.getTextFieldEmail().getText();
        String phoneNumberStr = forgotPasswordView.getTextFieldPhoneNumber().getText();
        boolean userFound = false;

        try {
            int phoneNumber = Integer.parseInt(phoneNumberStr);
            List<User> users = userRepository.findAll();

            for (User user : users) {
                if (user.getEmail().equals(email) && user.getSdt() == phoneNumber) {
                    userFound = true;
                    String message = "Tìm Thấy Người Dùng: " + user.getTen() + "\nPassword: " + user.getMatKhau();
                    JOptionPane.showMessageDialog(forgotPasswordView, message, "User Found", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(forgotPasswordView, "Email hoặc PhoneNumber Không đúng.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(forgotPasswordView, "Nhập sai PhoneNumber.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
