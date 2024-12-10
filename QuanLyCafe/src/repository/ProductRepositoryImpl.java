package repository;

import model.Product;
import repository.IRepository.IProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static final String FILE_PATH = "products.txt";
    private List<Product> products = new ArrayList<>();

    public ProductRepositoryImpl() {
        loadProductsFromFile();
        if (products.isEmpty()) {
            initializeProducts();
            saveProductsToFile();
        }
    }

    private void loadProductsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                if (!list.isEmpty() && list.get(0) instanceof Product) {
                    products = new ArrayList<>();
                    for (Object item : list) {
                        products.add((Product) item);
                    }
                    System.out.println("Danh sách sản phẩm đã được đọc từ file thành công.");
                } else {
                    throw new IOException("Dữ liệu trong file không phải là List<Product>");
                }
            } else {
                throw new IOException("Dữ liệu trong file không phải là List<?>");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chưa Có Món Đồ Uống Nào");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void saveProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeProducts() {
        products.add(new Product(1, "Cà phê Trung Nguyên", "Đặc trưng 1", 50000));
        products.add(new Product(2, "Cà phê Arabica", "Đặc trưng 2", 55000));
        products.add(new Product(3, "Cà phê Brasil", "Đặc trưng 3", 60000));
        products.add(new Product(4, "Cà phê VIP", "Đặc trưng 4", 70000));
        products.add(new Product(5, "Mixue", "Đặc trưng 5", 45000));
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        saveProductsToFile();
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getTenSP().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
        saveProductsToFile();
    }

    @Override
    public void clear() {
        products.clear();
        saveProductsToFile();
    }
}
