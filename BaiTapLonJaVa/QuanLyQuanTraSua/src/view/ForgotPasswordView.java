package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.ForgotPasswordController;

public class ForgotPasswordView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel jLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordView frame = new ForgotPasswordView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ForgotPasswordView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lbl_email.setBounds(221, 189, 333, 25);
		contentPane.add(lbl_email);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(447, 189, 483, 25);
		contentPane.add(textField);

		JLabel lbl_phonenumber = new JLabel("PhoneNumber");
		lbl_phonenumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lbl_phonenumber.setBounds(221, 239, 280, 25);
		contentPane.add(lbl_phonenumber);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(447, 239, 483, 25);
		contentPane.add(textField_1);

		Button button_login = new Button("Login");
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginView().setVisible(true);
				dispose();
			}
		});
		button_login.setFont(new Font("Arial Black", Font.BOLD, 22));
		button_login.setBackground(Color.WHITE);
		button_login.setBackground(Color.CYAN);
		button_login.setBounds(434, 309, 120, 35);
		contentPane.add(button_login);

		Button button_exit = new Button("Exit ");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setFont(new Font("Arial Black", Font.BOLD, 22));
		button_exit.setBackground(Color.WHITE);
		button_exit.setBackground(Color.CYAN);
		button_exit.setBounds(668, 309, 100, 35);
		contentPane.add(button_exit);
//
//        JButton signup1 = new JButton("SignUp");
//        signup1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new SignUpView().setVisible(true);
//                dispose();
//            }
//        });
//        signup1.setFont(new Font("Arial Black", Font.PLAIN, 22));
//        signup1.setBackground(Color.WHITE);
//        signup1.setBounds(622, 514, 136, 41);
//        contentPane.add(signup1);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(445, 309, 109, 41);
		btnFind.setBackground(Color.CYAN);
		btnFind.setFont(new Font("Arial Black", Font.PLAIN, 22));
		contentPane.add(btnFind);

		JLabel lblNewLabel = new JLabel("ForgotPassword");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(390, 85, 385, 71);
		contentPane.add(lblNewLabel);

		ForgotPasswordController forgotPasswordController = new ForgotPasswordController(this);
		btnFind.addActionListener(forgotPasswordController);

		jLabel = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("ForgotPasswordView.jpg"));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(1300, 650, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		jLabel.setIcon(scaledIcon);
		jLabel.setBounds(0, 0, 1300, 650); 
		contentPane.add(jLabel);
		

		this.setVisible(true);
	}

	public JTextField getTextFieldEmail() {
		return textField;
	}

	public JTextField getTextFieldPhoneNumber() {
		return textField_1;
	}
}
