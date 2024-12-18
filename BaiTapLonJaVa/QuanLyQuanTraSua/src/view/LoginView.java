package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JPasswordField passwordField;
	private JLabel jLabel;

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
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1064, 589);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

//        JPanel contentPane_1 = new JPanel();
//        contentPane_1.setLayout(null);
//        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
//        contentPane_1.setBounds(0, 10, 1060, 558);
//        contentPane.add(contentPane_1);

        JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lbl_email.setForeground(Color.BLACK);
		lbl_email.setBounds(427, 203, 333, 25);
		contentPane.add(lbl_email);

        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(555, 203, 430, 25);
        contentPane.add(textFieldEmail);

        JLabel label_password = new JLabel("Password");
		label_password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		label_password.setForeground(Color.BLACK);
		label_password.setBounds(427, 262, 240, 25);
		contentPane.add(label_password);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordField.setBounds(555, 261, 430, 26);
        contentPane.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial Black", Font.BOLD, 22));
        btnLogin.setBackground(UIManager.getColor("Button.highlight"));
        btnLogin.setBackground(Color.CYAN);
        btnLogin.setBounds(393, 364, 116, 43);
        btnLogin.setActionCommand("Login");
        contentPane.add(btnLogin);

        JButton btnForgetPassword = new JButton("Forget Password ?");
        btnForgetPassword.setFont(new Font("Arial Black", Font.BOLD, 22));
        btnForgetPassword.setBackground(UIManager.getColor("Button.highlight"));
        btnForgetPassword.setBounds(555, 468, 300, 42);
        btnForgetPassword.setBackground(Color.CYAN);
        btnForgetPassword.setActionCommand("Forget Password ?");
        contentPane.add(btnForgetPassword);

        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Arial Black", Font.BOLD, 22));
        btnExit.setBackground(UIManager.getColor("Button.highlight"));
        btnExit.setBounds(865, 364, 120, 43);
        btnExit.setBackground(Color.CYAN);
        btnExit.setActionCommand("Exit");
        contentPane.add(btnExit);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Arial Black", Font.BOLD, 22));
        btnClear.setBackground(UIManager.getColor("Button.highlight"));
        btnClear.setBackground(Color.CYAN);
        btnClear.setBounds(627, 364, 120, 43);
        btnClear.setActionCommand("Clear");
        contentPane.add(btnClear);

        JLabel lblLogIn = new JLabel("Log In");
        lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogIn.setFont(new Font("Algerian", Font.BOLD, 50));
        lblLogIn.setForeground(Color.MAGENTA);
        lblLogIn.setBounds(596, 71, 280, 48);
        contentPane.add(lblLogIn);

//        JButton btnSignUp = new JButton("SignUp");
//        btnSignUp.setBackground(UIManager.getColor("Button.highlight"));
//        btnSignUp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//        btnSignUp.setBounds(741, 471, 154, 43);
//        btnSignUp.setActionCommand("SignUp");
//        contentPane_1.add(btnSignUp);

        LoginController action = new LoginController(this);
        btnLogin.addActionListener(action);
        btnForgetPassword.addActionListener(action);
        btnExit.addActionListener(action);
        btnClear.addActionListener(action);
//        btnSignUp.addActionListener(action);

		// Set up the background image
		jLabel = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("LoginIcon.jpg"));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(1500, 750, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		jLabel.setIcon(scaledIcon);
		jLabel.setBounds(0, 0, 1500, 750); // Make sure it covers the whole frame
		contentPane.add(jLabel);
        
        this.setVisible(true);
    }

    public JTextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void xoaForm() {
        textFieldEmail.setText("");
		passwordField.setText("");
	}
}
