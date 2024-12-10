package view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.AdminController;
import model.User;
import model.Bill;
import java.util.List;
import javax.swing.SwingConstants;

public class AdminView extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldUsername;
    private JTextField textFieldNewItemName;
    private JTextField textFieldNewItemPrice;
    private JTextField textFieldDeleteItemName;
    private JTable table;
    private DefaultTableModel tableModel;
    private DefaultTableModel billTableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminView frame = new AdminView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminView() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblAdminPanel = new JLabel("Admin Panel");
        lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdminPanel.setBounds(10, 10, 864, 40);
        contentPane.add(lblAdminPanel);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsername.setBounds(20, 60, 100, 25);
        contentPane.add(lblUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(120, 60, 200, 25);
        contentPane.add(textFieldUsername);
        textFieldUsername.setColumns(10);

        JButton btnGetAccountByUsername = new JButton("Get Account");
        btnGetAccountByUsername.setActionCommand("Get Account By Username");
        btnGetAccountByUsername.setBounds(330, 60, 150, 25);
        contentPane.add(btnGetAccountByUsername);

        JButton btnDeleteAccount = new JButton("Delete Account");
        btnDeleteAccount.setActionCommand("Delete Account");
        btnDeleteAccount.setBounds(490, 60, 150, 25);
        contentPane.add(btnDeleteAccount);

        JButton btnViewPersonalInfo = new JButton("View Personal Info");
        btnViewPersonalInfo.setActionCommand("View Personal Info");
        btnViewPersonalInfo.setBounds(650, 60, 150, 25);
        contentPane.add(btnViewPersonalInfo);

        JLabel lblNewItem = new JLabel("Add New Item:");
        lblNewItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewItem.setBounds(20, 100, 100, 25);
        contentPane.add(lblNewItem);

        JLabel lblNewItemName = new JLabel("Name:");
        lblNewItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewItemName.setBounds(20, 130, 50, 25);
        contentPane.add(lblNewItemName);

        textFieldNewItemName = new JTextField();
        textFieldNewItemName.setBounds(80, 130, 150, 25);
        contentPane.add(textFieldNewItemName);
        textFieldNewItemName.setColumns(10);

        JLabel lblNewItemPrice = new JLabel("Price:");
        lblNewItemPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewItemPrice.setBounds(240, 130, 50, 25);
        contentPane.add(lblNewItemPrice);

        textFieldNewItemPrice = new JTextField();
        textFieldNewItemPrice.setBounds(300, 130, 100, 25);
        contentPane.add(textFieldNewItemPrice);
        textFieldNewItemPrice.setColumns(10);

        JButton btnAddNewItem = new JButton("Add New Item");
        btnAddNewItem.setActionCommand("Add New Item");
        btnAddNewItem.setBounds(410, 130, 150, 25);
        contentPane.add(btnAddNewItem);

        JLabel lblDeleteItem = new JLabel("Delete Item:");
        lblDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDeleteItem.setBounds(20, 170, 100, 25);
        contentPane.add(lblDeleteItem);

        JLabel lblDeleteItemName = new JLabel("Name:");
        lblDeleteItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDeleteItemName.setBounds(20, 200, 50, 25);
        contentPane.add(lblDeleteItemName);

        textFieldDeleteItemName = new JTextField();
        textFieldDeleteItemName.setBounds(80, 200, 150, 25);
        contentPane.add(textFieldDeleteItemName);
        textFieldDeleteItemName.setColumns(10);

        JButton btnDeleteItem = new JButton("Delete Item");
        btnDeleteItem.setActionCommand("Delete Item");
        btnDeleteItem.setBounds(240, 200, 150, 25);
        contentPane.add(btnDeleteItem);

        JButton btnGetTotalBills = new JButton("Get Total Bills");
        btnGetTotalBills.setActionCommand("Get Total Bills");
        btnGetTotalBills.setBounds(400, 200, 150, 25);
        contentPane.add(btnGetTotalBills);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 240, 864, 510);
        contentPane.add(scrollPane);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email", "Phone", "Address"}, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        billTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email", "Phone", "Date", "Total"}, 0);
        JTable billTable = new JTable(billTableModel);
        JScrollPane billScrollPane = new JScrollPane(billTable);
        billScrollPane.setBounds(10, 760, 864, 200);
        contentPane.add(billScrollPane);

        // Create controller and assign actions
        AdminController adminController = new AdminController(this);
        btnGetAccountByUsername.addActionListener(adminController);
        btnDeleteAccount.addActionListener(adminController);
        btnViewPersonalInfo.addActionListener(adminController);
        btnAddNewItem.addActionListener(adminController);
        btnDeleteItem.addActionListener(adminController);
        btnGetTotalBills.addActionListener(adminController);
    }

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
            return -1;
        }
    }

    public String getDeleteItemName() {
        return textFieldDeleteItemName.getText();
    }

    public void clearNewItemForm() {
        textFieldNewItemName.setText("");
        textFieldNewItemPrice.setText("");
    }

    public void updateUserList(List<User> users) {
        tableModel.setRowCount(0);
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getMaNV(), user.getTen(), user.getEmail(), user.getSdt(), user.getDiaChi()});
        }
    }

    public void updateBillList(List<Bill> bills) {
        billTableModel.setRowCount(0);
        for (Bill bill : bills) {
            billTableModel.addRow(new Object[]{bill.getMaHD(), bill.getTen(), bill.getEmail(), bill.getSDT(), bill.getNgayDat(), bill.getTongTien()});
        }
    }

    public void showUserDetails(User user) {
        JOptionPane.showMessageDialog(this, "ID: " + user.getMaNV() + "\nName: " + user.getTen() + "\nEmail: " + user.getEmail() + "\nPhone: " + user.getSdt() + "\nAddress: " + user.getDiaChi(), "User Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
