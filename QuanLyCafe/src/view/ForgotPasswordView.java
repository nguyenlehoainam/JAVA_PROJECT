package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPasswordView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public ForgotPasswordView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lbl_email.setBounds(221, 210, 333, 25);
		contentPane.add(lbl_email);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(447, 210, 483, 25);
		contentPane.add(textField);

		JLabel lbl_phonenumber = new JLabel("PhoneNumber");
		lbl_phonenumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lbl_phonenumber.setBounds(221, 293, 280, 25);
		contentPane.add(lbl_phonenumber);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(447, 293, 483, 25);
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
		button_login.setBounds(434, 520, 120, 35);
		contentPane.add(button_login);

		Button button_exit = new Button("Exit ");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_exit.setFont(new Font("Arial Black", Font.BOLD, 22));
		button_exit.setBackground(Color.WHITE);
		button_exit.setBounds(658, 422, 100, 35);
		contentPane.add(button_exit);

		JButton signup1 = new JButton("SignUp");
		signup1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpView().setVisible(true);
				dispose();
			}
		});
		signup1.setFont(new Font("Arial Black", Font.PLAIN, 22));
		signup1.setBackground(Color.WHITE);
		signup1.setBounds(622, 514, 136, 41);
		contentPane.add(signup1);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(445, 422, 109, 41);
		btnFind.setFont(new Font("Arial Black", Font.PLAIN, 22));
		contentPane.add(btnFind);

		JLabel lblNewLabel = new JLabel("ForgotPassword");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 40));
		lblNewLabel.setBounds(399, 78, 385, 71);
		contentPane.add(lblNewLabel);
		this.setVisible(true);
	}

}
