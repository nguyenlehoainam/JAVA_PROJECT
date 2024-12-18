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
import view.BillView;
import view.SignUpView;

public class AdminController implements ActionListener {

    private AdminView adminView;
    private IUserRepository userRepository;
    private IBillRepository billRepository;
    private IProductRepository productRepository;
    public AdminController(AdminView adminView, User loggedInUser) {
        this.adminView = adminView;
        this.userRepository = new UserRepositoryImpl();
        this.billRepository = new BillRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        loadAccounts();  // Tải tất cả tài khoản khi khởi tạo
        loadProducts();  // Tải tất cả sản phẩm khi khởi tạo
        adminView.getSignUpButton().addActionListener(this);
    }

    private void loadAccounts() {
        List<User> users = userRepository.findAll();
        adminView.updateUserList(users);
    }

    private void loadProducts() {
        List<Product> products = productRepository.findAll();
        adminView.updateProductList(products);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Tìm Kiếm Tài Khoản theo tên :":
                getAccountByName();
                break;
            case "Xóa Tài Khoản":
                deleteAccount();
                break;
            case "Thêm sản phẩm mới":
                addNewItem();
                break;
            case "Xem tổng hóa đơn":
                getTotalBills();
                break;
            case "Xóa món":
                deleteItem();
                break;
            case "SignUp":  
                new SignUpView().setVisible(true);
                adminView.dispose();
                break;
            default:
                break;
        }
    }

    private void getAccountByName() {
        String name = adminView.getUsernameInput();
        List<User> users = userRepository.findAll();
        User foundUser = null;
        for (User user : users) {
            if (user.getTen().equalsIgnoreCase(name)) {
                foundUser = user;
                break;
            }
        }

        if (foundUser != null) {
            adminView.updateUserList(List.of(foundUser));  // Cập nhật bảng chỉ với tài khoản tìm được
        } else {
            JOptionPane.showMessageDialog(adminView, "Không tìm thấy tài khoản", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAccount() {
        String name = adminView.getUsernameInput();
        List<User> users = userRepository.findAll();
        User foundUser = null;
        for (User user : users) {
            if (user.getTen().equalsIgnoreCase(name)) {
                foundUser = user;
                break;
            }
        }

        if (foundUser != null) {
            userRepository.delete(foundUser);
            JOptionPane.showMessageDialog(adminView, "Xóa thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadAccounts();  // Tải lại danh sách sau khi xóa tài khoản
        } else {
            JOptionPane.showMessageDialog(adminView, "Không tìm thấy tài khoản", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNewItem() {
        String name = adminView.getNewItemName();
        double price = adminView.getNewItemPrice();
        if (name.isEmpty() || price <= 0) {
            JOptionPane.showMessageDialog(adminView, "Sản phẩm không hợp lệ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Product newProduct = new Product(0, name, price);
        productRepository.save(newProduct);
        JOptionPane.showMessageDialog(adminView, "Thêm sản phẩm thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
        adminView.clearNewItemForm();
        loadProducts();  // Tải lại danh sách sản phẩm sau khi thêm sản phẩm mới
    }

    private void deleteItem() {
        String itemName = adminView.getDeleteItemName();
        Product product = productRepository.findByName(itemName);
        if (product != null) {
            productRepository.delete(product);
            JOptionPane.showMessageDialog(adminView, "Xóa sản phẩm thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadProducts();  // Tải lại danh sách sản phẩm sau khi xóa sản phẩm
        } else {
            JOptionPane.showMessageDialog(adminView, "Không tìm thấy sản phẩm", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getTotalBills() {
        List<Bill> bills = billRepository.findAll();
        new BillView(bills).setVisible(true);  // Hiển thị BillView với danh sách các hóa đơn
    }
}
