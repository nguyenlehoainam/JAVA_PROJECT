package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.LoginController;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.JOptionPane;

public class LoginView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_2;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView frame = new LoginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginView() {
        setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1064, 589);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        LoginController action = new LoginController(this);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel contentPane_1 = new JPanel();
        contentPane_1.setLayout(null);
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_1.setBounds(0, 10, 1060, 558);
        contentPane.add(contentPane_1);

        JLabel lable_password = new JLabel("PassWord");
        lable_password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lable_password.setBounds(362, 261, 240, 25);
        contentPane_1.add(lable_password);

        JLabel lbl_email = new JLabel("Email");
        lbl_email.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lbl_email.setBounds(362, 203, 333, 25);
        contentPane_1.add(lbl_email);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_2.setColumns(10);
        textField_2.setBounds(555, 203, 430, 25);
        contentPane_1.add(textField_2);

        Button button_signup = new Button("Login");
        button_signup.setFont(new Font("Arial Black", Font.BOLD, 22));
        button_signup.setBackground(UIManager.getColor("Button.highlight"));
        button_signup.setBounds(356, 364, 116, 43);
        button_signup.setActionCommand("Login");
        button_signup.addActionListener(action);
        contentPane_1.add(button_signup);

        Button button_forget = new Button("Forget Password ?");
        button_forget.setFont(new Font("Arial Black", Font.BOLD, 22));
        button_forget.setBackground(UIManager.getColor("Button.highlight"));
        button_forget.setBounds(394, 471, 227, 43);
        button_forget.setActionCommand("Forget Password ?");
        button_forget.addActionListener(action);
        contentPane_1.add(button_forget);

        Button button_exit = new Button("Exit ");
        button_exit.setFont(new Font("Arial Black", Font.BOLD, 22));
        button_exit.setBackground(UIManager.getColor("Button.highlight"));
        button_exit.setBounds(855, 364, 83, 43);
        button_exit.setActionCommand("Exit");
        button_exit.addActionListener(action);
        contentPane_1.add(button_exit);

        Button button_clear = new Button("Clear");
        button_clear.setFont(new Font("Arial Black", Font.BOLD, 22));
        button_clear.setBackground(UIManager.getColor("Button.highlight"));
        button_clear.setBounds(624, 364, 103, 43);
        button_clear.setActionCommand("Clear");
        button_clear.addActionListener(action);
        contentPane_1.add(button_clear);

        JLabel notice = new JLabel("LogIn");
        notice.setHorizontalAlignment(SwingConstants.CENTER);
        notice.setFont(new Font("Algerian", Font.BOLD, 50));
        notice.setBounds(394, 81, 280, 48);
        contentPane_1.add(notice);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordField.setBounds(557, 261, 428, 26);
        contentPane_1.add(passwordField);

        JButton signup1 = new JButton("SignUp");
        signup1.setBackground(UIManager.getColor("Button.highlight"));
        signup1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        signup1.setBounds(741, 471, 154, 43);
        signup1.setActionCommand("SignUp");
        signup1.addActionListener(action);
        contentPane_1.add(signup1);

        this.setVisible(true);
    }

    public JTextField getTextFieldEmail() {
        return textField_2;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void xoaForm() {
        textField_2.setText("");
        passwordField.setText("");
    }
}
