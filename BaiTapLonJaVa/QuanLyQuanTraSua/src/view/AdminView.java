package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.AdminController;
import model.User;
import model.Product;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldNewItemName;
	private JTextField textFieldNewItemPrice;
	private JTextField textFieldDeleteItemName;
	private JTable userTable;
	private JTable productTable;
	private DefaultTableModel userTableModel;
	private DefaultTableModel productTableModel;
	private JButton btnSignUp;
	private JLabel jLabel; // Background image label

	public AdminView() {
		this(null); // Calls the other constructor
	}

	public AdminView(User loggedInUser) {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Admin Panel Label
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setBounds(10, 10, 864, 40);
		contentPane.add(lblAdminPanel);

		// Username input section
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(20, 60, 100, 25);
		contentPane.add(lblUsername);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(120, 60, 200, 25);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		// Tao font
		
		Font font = new Font("Tahoma", Font.BOLD, 14);
		
		// Get Account and Delete Account buttons
		JButton btnGetAccountByUsername = new JButton("Get Account");
		btnGetAccountByUsername.setBounds(330, 60, 150, 25);
		btnGetAccountByUsername.setFont(font);
		btnGetAccountByUsername.setBackground(Color.CYAN);
		contentPane.add(btnGetAccountByUsername);

		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setBounds(490, 60, 150, 25);
		btnDeleteAccount.setFont(font);
		btnDeleteAccount.setBackground(Color.CYAN);
		contentPane.add(btnDeleteAccount);

		// Logout button action
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(650, 100, 150, 25);
		btnLogout.setFont(font);
		btnLogout.setBackground(Color.CYAN);
		contentPane.add(btnLogout);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Closes current window
				new LoginView().setVisible(true); // Opens login view
			}
		});

		// Add new item section
		JLabel lblNewItem = new JLabel("Add New Item:");
		lblNewItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewItem.setBounds(20, 100, 121, 25);
		contentPane.add(lblNewItem);

		JLabel lblNewItemName = new JLabel("Name:");
		lblNewItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewItemName.setBounds(20, 130, 50, 25);
		contentPane.add(lblNewItemName);

		textFieldNewItemName = new JTextField();
		textFieldNewItemName.setBounds(80, 130, 150, 25);
		contentPane.add(textFieldNewItemName);
		textFieldNewItemName.setColumns(10);

		JLabel lblNewItemPrice = new JLabel("Price:");
		lblNewItemPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewItemPrice.setBounds(240, 130, 50, 25);
		contentPane.add(lblNewItemPrice);

		textFieldNewItemPrice = new JTextField();
		textFieldNewItemPrice.setBounds(300, 130, 100, 25);
		contentPane.add(textFieldNewItemPrice);
		textFieldNewItemPrice.setColumns(10);

		JButton btnAddNewItem = new JButton("Add New Item");
		btnAddNewItem.setBounds(410, 130, 150, 25);
		btnAddNewItem.setFont(font);
		btnAddNewItem.setBackground(Color.CYAN);
		contentPane.add(btnAddNewItem);

		// Delete Item section
		JLabel lblDeleteItem = new JLabel("Delete Item:");
		lblDeleteItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeleteItem.setBounds(20, 170, 100, 25);
		contentPane.add(lblDeleteItem);

		JLabel lblDeleteItemName = new JLabel("Name:");
		lblDeleteItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeleteItemName.setBounds(20, 200, 50, 25);
		contentPane.add(lblDeleteItemName);

		textFieldDeleteItemName = new JTextField();
		textFieldDeleteItemName.setBounds(80, 200, 150, 25);
		contentPane.add(textFieldDeleteItemName);
		textFieldDeleteItemName.setColumns(10);

		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(240, 200, 150, 25);
		btnDeleteItem.setFont(font);
		btnDeleteItem.setBackground(Color.CYAN);
		contentPane.add(btnDeleteItem);

		// Total Bills button
		JButton btnGetTotalBills = new JButton("Get Total Bills");
		btnGetTotalBills.setBounds(400, 200, 150, 25);
		btnGetTotalBills.setFont(font);
		btnGetTotalBills.setBackground(Color.CYAN);
		contentPane.add(btnGetTotalBills);

		// User Table
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(10, 240, 864, 200);
		contentPane.add(scrollPaneUser);

		userTableModel = new DefaultTableModel(new Object[] { "ID", "Name", "Email", "Phone", "Address" }, 0);
		userTable = new JTable(userTableModel);
		//userTable.setFont(font);
		scrollPaneUser.setViewportView(userTable);

		// Cập nhật bảng không cho phép chỉnh sửa
		userTable.setEnabled(false); // Vô hiệu hóa việc chỉnh sửa toàn bộ bảng

		// Product Table
		JScrollPane scrollPaneProduct = new JScrollPane();
		scrollPaneProduct.setBounds(10, 450, 864, 200);
		contentPane.add(scrollPaneProduct);

		productTableModel = new DefaultTableModel(new Object[] { "ID", "Name", "Price" }, 0);
		productTable = new JTable(productTableModel);
		//productTable.setFont(font);
		scrollPaneProduct.setViewportView(productTable);

		// Cập nhật bảng không cho phép chỉnh sửa
		productTable.setEnabled(false); // Vô hiệu hóa việc chỉnh sửa toàn bộ bảng
		
		
		// Sign Up button
		btnSignUp = new JButton("SignUp");
		btnSignUp.setBackground(UIManager.getColor("Button.highlight"));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignUp.setBackground(Color.CYAN);
		btnSignUp.setBounds(650, 200, 150, 25);
		contentPane.add(btnSignUp);

		// Connect controller
		AdminController adminController = new AdminController(this, loggedInUser);
		btnGetAccountByUsername.addActionListener(adminController);
		btnDeleteAccount.addActionListener(adminController);
		btnAddNewItem.addActionListener(adminController);
		btnDeleteItem.addActionListener(adminController);
		btnGetTotalBills.addActionListener(adminController);
		btnSignUp.addActionListener(adminController);

		// Set up the background image
		jLabel = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("ForgotPasswordView.jpg"));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(1300, 650, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		jLabel.setIcon(scaledIcon);
		jLabel.setBounds(0, 0, 1300, 650); // Ensure it covers the whole frame
		contentPane.add(jLabel);
		
		// Get Account and Delete Account buttons
		btnGetAccountByUsername.setActionCommand("Tìm Kiếm Tài Khoản theo tên :");
		btnDeleteAccount.setActionCommand("Xóa Tài Khoản");
		btnAddNewItem.setActionCommand("Thêm sản phẩm mới");
		btnDeleteItem.setActionCommand("Xóa món");
		btnGetTotalBills.setActionCommand("Xem tổng hóa đơn");
		btnSignUp.setActionCommand("SignUp");


		// Set visibility of the view at the end
		this.setVisible(true);
	}

	// Getters for form inputs
	public String getUsernameInput() {
		return textFieldUsername.getText();
	}

	public String getNewItemName() {
		return textFieldNewItemName.getText();
	}

	public double getNewItemPrice() {
		try {
			return Double.parseDouble(textFieldNewItemPrice.getText());
		} catch (NumberFormatException e) {
			return -1; // Invalid price
		}
	}

	public String getDeleteItemName() {
		return textFieldDeleteItemName.getText();
	}

	public JButton getSignUpButton() {
		return btnSignUp;
	}

	public void clearNewItemForm() {
		textFieldNewItemName.setText("");
		textFieldNewItemPrice.setText("");
	}

	// Update tables with lists of users and products
	public void updateUserList(List<User> users) {
		userTableModel.setRowCount(0);
		for (User user : users) {
			userTableModel.addRow(
					new Object[] { user.getMaNV(), user.getTen(), user.getEmail(), user.getSdt(), user.getDiaChi() });
		}
	}

	public void updateProductList(List<Product> products) {
		productTableModel.setRowCount(0);
		for (Product product : products) {
			productTableModel.addRow(new Object[] { product.getMaSP(), product.getTenSP(), product.getGia() });
		}
	}
}
