package repository.IRepository;



import model.Product;
import java.util.List;

public interface IProductRepository {
    public Product save(Product product);
    public List<Product> findAll();
    public Product findByName(String name);
    public void delete(Product product);
    public void clear();
}
