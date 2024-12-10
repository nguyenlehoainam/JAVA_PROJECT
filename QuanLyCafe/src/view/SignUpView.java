package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.SignUpController;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class SignUpView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_name;
    private JTextField textField_email;
    private JTextField textField_address;
    private JTextField textField_phonenumber;
    private JPasswordField passwordField;
    private JComboBox<String> comboBoxRole;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUpView frame = new SignUpView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SignUpView() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1154, 772);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblName.setBounds(362, 197, 240, 25);
        contentPane.add(lblName);

        textField_name = new JTextField();
        textField_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_name.setBounds(555, 197, 483, 25);
        contentPane.add(textField_name);
        textField_name.setColumns(10);

        JLabel lblPassword = new JLabel("PassWord");
        lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblPassword.setBounds(362, 261, 240, 25);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordField.setBounds(555, 261, 483, 26);
        contentPane.add(passwordField);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblAddress.setBounds(362, 322, 230, 25);
        contentPane.add(lblAddress);

        textField_address = new JTextField();
        textField_address.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_address.setBounds(555, 326, 483, 25);
        contentPane.add(textField_address);
        textField_address.setColumns(10);

        JLabel lblPhoneNumber = new JLabel("PhoneNumber");
        lblPhoneNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblPhoneNumber.setBounds(362, 381, 280, 25);
        contentPane.add(lblPhoneNumber);

        textField_phonenumber = new JTextField();
        textField_phonenumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_phonenumber.setBounds(555, 381, 483, 25);
        contentPane.add(textField_phonenumber);
        textField_phonenumber.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblEmail.setBounds(364, 433, 333, 25);
        contentPane.add(lblEmail);

        textField_email = new JTextField();
        textField_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_email.setBounds(555, 433, 483, 25);
        contentPane.add(textField_email);
        textField_email.setColumns(10);

        JLabel lblRole = new JLabel("Role");
        lblRole.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblRole.setBounds(362, 483, 240, 25);
        contentPane.add(lblRole);

        comboBoxRole = new JComboBox<>();
        comboBoxRole.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxRole.setBounds(555, 483, 483, 25);
        comboBoxRole.addItem("USER");
        comboBoxRole.addItem("ADMIN");
        contentPane.add(comboBoxRole);

        Button buttonSave = new Button("Save");
        buttonSave.setActionCommand("Save");
        buttonSave.setFont(new Font("Arial Black", Font.BOLD, 22));
        buttonSave.setBackground(UIManager.getColor("Button.highlight"));
        buttonSave.setBounds(408, 528, 83, 43);
        contentPane.add(buttonSave);

        Button buttonClear = new Button("Clear");
        buttonClear.setActionCommand("Clear");
        buttonClear.setFont(new Font("Arial Black", Font.BOLD, 22));
        buttonClear.setBackground(UIManager.getColor("Button.highlight"));
        buttonClear.setBounds(823, 631, 103, 43);
        contentPane.add(buttonClear);

        Button buttonLogin = new Button("Login");
        buttonLogin.setFont(new Font("Arial Black", Font.BOLD, 22));
        buttonLogin.setBackground(UIManager.getColor("Button.highlight"));
        buttonLogin.setBounds(664, 528, 116, 43);
        contentPane.add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });

        Button buttonExit = new Button("Exit ");
        buttonExit.setFont(new Font("Arial Black", Font.BOLD, 22));
        buttonExit.setBackground(UIManager.getColor("Button.highlight"));
        buttonExit.setBounds(944, 528, 83, 43);
        contentPane.add(buttonExit);

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel notice = new JLabel("Sign Up");
        notice.setHorizontalAlignment(SwingConstants.CENTER);
        notice.setFont(new Font("Algerian", Font.BOLD, 50));
        notice.setBounds(500, 97, 280, 48);
        contentPane.add(notice);

        SignUpController signUpController = new SignUpController(this);
        buttonSave.addActionListener(signUpController);
        buttonClear.addActionListener(signUpController);
    }

    public void xoaForm() {
        textField_name.setText("");
        textField_email.setText("");
        textField_address.setText("");
        textField_phonenumber.setText("");
        passwordField.setText("");
        comboBoxRole.setSelectedIndex(0);
    }

    public JTextField getTextFieldName() {
        return textField_name;
    }

    public JTextField getTextFieldEmail() {
        return textField_email;
    }

    public JTextField getTextFieldAddress() {
        return textField_address;
    }

    public JTextField getTextFieldPhoneNumber() {
        return textField_phonenumber;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public String getSelectedRole() {
        return (String) comboBoxRole.getSelectedItem();
    }
}
