package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.List;
import model.User;
import model.Bill;
import model.Product;
import repository.UserRepositoryImpl;
import repository.IRepository.IBillRepository;
import repository.IRepository.IProductRepository;
import repository.IRepository.IUserRepository;
import repository.BillRepositoryImpl;
import repository.ProductRepositoryImpl;
import view.AdminView;

public class AdminController implements ActionListener {

    private AdminView adminView;
    private IUserRepository userRepository;
    private IBillRepository billRepository;
    private IProductRepository productRepository;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;
        this.userRepository = new UserRepositoryImpl();
        this.billRepository = new BillRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        loadAccounts();  // Tải tất cả tài khoản khi khởi tạo
    }

    private void loadAccounts() {
        List<User> users = userRepository.findAll();
        adminView.updateUserList(users);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Tìm Kiếm Tài Khoản theo tên :":
                getAccountByUsername();
                break;
            case "Xóa Tài Khoản":
                deleteAccount();
                break;
            case "Xem Thông Tin Cá Nhân":
                viewPersonalInfo();
                break;
            case "Thêm sản phẩm mới":
                addNewItem();
                break;
            case "xem tổng hóa đơn":
                getTotalBills();
                break;
            case "xóa món":
                deleteItem();
                break;
            default:
                break;
        }
    }

    private void getAccountByUsername() {
        String username = adminView.getUsernameInput();
        User user = userRepository.findByEmail(username);
        if (user != null) {
            adminView.updateUserList(List.of(user));  // Cập nhật bảng chỉ với tài khoản tìm được
            adminView.showUserDetails(user);
        } else {
            JOptionPane.showMessageDialog(adminView, "không tìm thấy tài khoản", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAccount() {
        String username = adminView.getUsernameInput();
        User user = userRepository.findByEmail(username);
        if (user != null) {
            userRepository.delete(user);
            JOptionPane.showMessageDialog(adminView, "Xóa Thành Công", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadAccounts();  // Tải lại danh sách sau khi xóa tài khoản
        } else {
            JOptionPane.showMessageDialog(adminView, "Không Tìm Thấy Tài Khoản", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewPersonalInfo() {
        String username = adminView.getUsernameInput();
        User user = userRepository.findByEmail(username);
        if (user != null) {
            adminView.showUserDetails(user);
        } else {
            JOptionPane.showMessageDialog(adminView, "Không Tìm Thấy Tài Khoản", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNewItem() {
        String name = adminView.getNewItemName();
        double price = adminView.getNewItemPrice();
        if (name.isEmpty() || price <= 0) {
            JOptionPane.showMessageDialog(adminView, "Sản Phẩm Không Hợp Lệ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Product newProduct = new Product(0, name, "", price);
        productRepository.save(newProduct);
        JOptionPane.showMessageDialog(adminView, "Thêm Sản Phẩm Thành Công", "Success", JOptionPane.INFORMATION_MESSAGE);
        adminView.clearNewItemForm();
    }

    private void getTotalBills() {
        List<Bill> bills = billRepository.findAll();
        adminView.updateBillList(bills);
    }

    private void deleteItem() {
        String itemName = adminView.getDeleteItemName();
        Product product = productRepository.findByName(itemName);
        if (product != null) {
            productRepository.delete(product);
            JOptionPane.showMessageDialog(adminView, "Xóa Sản Phẩm Thành Công", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(adminView, "không Tìm Thấy Sản Phẩm", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
