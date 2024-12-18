package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ProductController;
import model.Product;
import repository.ProductRepositoryImpl;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldPrice;
	private JTextField textFieldTotal;
	private JComboBox<String> comboBoxMenu;
	private JComboBox<String> comboBoxQuantity;
	private List<Product> listProduct;
	private JLabel jLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductView() {
		setTitle("Place Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ProductController action = new ProductController(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 18);
		
		JButton btnGenerateBill = new JButton("GENERATE BILL & PRINT");
		btnGenerateBill.addActionListener(action);
		btnGenerateBill.setBackground(Color.PINK);
		btnGenerateBill.setBounds(305, 511, 313, 57);
		btnGenerateBill.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnGenerateBill);

		JLabel placeOrder = new JLabel("Place Order");
		placeOrder.setHorizontalAlignment(SwingConstants.LEFT);
		placeOrder.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		placeOrder.setBounds(10, 10, 142, 34);
		contentPane.add(placeOrder);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblName.setBounds(10, 65, 118, 24);
		contentPane.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(10, 98, 428, 34);
		contentPane.add(textFieldName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblEmail.setBounds(10, 171, 118, 24);
		contentPane.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(10, 206, 428, 34);
		contentPane.add(textFieldEmail);

		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblPhone.setBounds(10, 273, 196, 24);
		contentPane.add(lblPhone);

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(10, 307, 428, 34);
		contentPane.add(textFieldPhone);

		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
		lblMenu.setBounds(10, 385, 132, 34);
		contentPane.add(lblMenu);

		comboBoxMenu = new JComboBox<>();
		comboBoxMenu.setMaximumRowCount(100);
		comboBoxMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		comboBoxMenu.setBounds(171, 393, 256, 28);
		listProduct = new ProductRepositoryImpl().findAll();
		comboBoxMenu.addItem("");
		for (Product product : listProduct) {
			comboBoxMenu.addItem(product.getTenSP());
		}
		comboBoxMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedProduct = (String) comboBoxMenu.getSelectedItem();
				for (Product product : listProduct) {
					if (product.getTenSP().equals(selectedProduct)) {
						textFieldPrice.setText(String.valueOf(product.getGia()));
						break;
					}
				}
			}
		});
		contentPane.add(comboBoxMenu);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblPrice.setBounds(546, 65, 142, 24);
		contentPane.add(lblPrice);

		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(656, 68, 96, 25);
		textFieldPrice.setEditable(false); // Không cho người dùng chỉnh sửa giá trực tiếp
		contentPane.add(textFieldPrice);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblQuantity.setBounds(546, 171, 131, 24);
		contentPane.add(lblQuantity);

		comboBoxQuantity = new JComboBox<>();
		comboBoxQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxQuantity.setMaximumRowCount(100);
		comboBoxQuantity.setBounds(656, 169, 98, 26);
		for (int i = 1; i <= 20; i++) {
			comboBoxQuantity.addItem(String.valueOf(i));
		}
		contentPane.add(comboBoxQuantity);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblTotal.setBounds(541, 282, 160, 24);
		contentPane.add(lblTotal);

		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(656, 279, 96, 27);
		contentPane.add(textFieldTotal);

		JButton totalButton = new JButton("Show Total");
		totalButton.addActionListener(action);
		totalButton.setBackground(Color.PINK);
		totalButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		totalButton.setBounds(822, 278, 160, 28);
		contentPane.add(totalButton);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 511, 150, 45);
		btnLogout.setBackground(Color.PINK);
		btnLogout.setFont(font);
		contentPane.add(btnLogout);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginView().setVisible(true);
			}
		});

		// Set up the background image
		jLabel = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("ProductIconView.jpg"));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(1500, 650, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		jLabel.setIcon(scaledIcon);
		jLabel.setBounds(0, 0, 1500, 650); // Make sure it covers the whole frame
		contentPane.add(jLabel);

		this.setVisible(true);
	}

	public String getUserName() {
		return textFieldName.getText();
	}

	public String getUserEmail() {
		return textFieldEmail.getText();
	}

	public String getUserPhone() {
		return textFieldPhone.getText();
	}

	public String getSelectedProduct() {
		return (String) comboBoxMenu.getSelectedItem();
	}

	public String getProductPrice() {
		return textFieldPrice.getText();
	}

	public String getSelectedQuantity() {
		return (String) comboBoxQuantity.getSelectedItem();
	}

	public void setTotalPrice(double total) {
		textFieldTotal.setText(String.valueOf(total));
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
