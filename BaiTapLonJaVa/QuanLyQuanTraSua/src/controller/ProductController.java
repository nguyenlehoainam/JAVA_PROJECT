package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.ProductView;
import model.Bill;
import model.Product;
import repository.BillRepositoryImpl;
import repository.ProductRepositoryImpl;
import java.util.List;

public class ProductController implements ActionListener {
    private ProductView productView;
    private ProductRepositoryImpl productRepository;
    private BillRepositoryImpl billRepository;

    public ProductController(ProductView productView) {
        this.productView = productView;
        this.productRepository = new ProductRepositoryImpl();
        this.billRepository = new BillRepositoryImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "GENERATE BILL & PRINT":
                handleGenerateBill();
                break;
            case "Show Total":
                handleShowTotal();
                break;
            default:
                JOptionPane.showMessageDialog(productView, "Sai Thao Tác!");
                break;
        }
    }

    private void handleGenerateBill() {
        String name = productView.getUserName();
        String email = productView.getUserEmail();
        String phone = productView.getUserPhone();
        String selectedProduct = productView.getSelectedProduct();
        String priceStr = productView.getProductPrice();
        String quantityStr = productView.getSelectedQuantity();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || selectedProduct.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(productView, "Hãy Điền Đầy Đủ Vào Chỗ Trống!");
            return;
        }

        double price = Double.parseDouble(priceStr);
        int quantity = Integer.parseInt(quantityStr);
        double total = price * quantity;

        Bill newBill = new Bill(0, name, Integer.parseInt(phone), email, java.time.LocalDate.now().toString(), total);
        billRepository.save(newBill);

        JOptionPane.showMessageDialog(productView, "Lưu Hóa Đơn Thành Công!\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nProduct: " + selectedProduct + "\nQuantity: " + quantity + "\nTotal: " + total);
    }

    private void handleShowTotal() {
        String selectedProduct = productView.getSelectedProduct();
        String quantityStr = productView.getSelectedQuantity();
        int quantity = Integer.parseInt(quantityStr);
        double price = 0.0;

        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getTenSP().equals(selectedProduct)) {
                price = product.getGia();
                break;
            }
        }

        double total = price * quantity;
        productView.setTotalPrice(total);
    }
}
