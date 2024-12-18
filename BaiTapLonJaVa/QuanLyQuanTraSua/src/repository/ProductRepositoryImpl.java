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
                    products = new ArrayList<Product>();
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
    	
    	products.add(new Product(1, "Mixue", 45000));
        products.add(new Product(2, "The Alley", 50000));
        products.add(new Product(3, "Trà Sữa Thiên Đường", 40000));
        products.add(new Product(4, "Trà Sữa Koi Thé", 45000));
        products.add(new Product(5, "Cà phê Trung Nguyên", 50000));
        products.add(new Product(6, "Cà phê Arabica", 55000));
        products.add(new Product(7, "Cà phê Brasil", 60000));
        products.add(new Product(8, "Cà phê VIP", 70000));
        products.add(new Product(9, "Mimi tea", 35000));
        products.add(new Product(10, "Heekcaa", 40000));
        products.add(new Product(11, "Share Tea", 35000));
        products.add(new Product(12, "Bubbly Tea" , 30000));
        products.add(new Product(13, "Trà Sữa Phúc Long", 35000));
        products.add(new Product(14, "Trà Sữa Socola", 40000));
        products.add(new Product(15, "trà Sữa Happy", 40000));

    }

    @Override
    public Product save(Product product) {
        int newId = generateNewId();  
        product.setMaSP(newId);  
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
    private int generateNewId() { 
    	return products.isEmpty() ? 1 : products.get(products.size() - 1).getMaSP() + 1; }
}
