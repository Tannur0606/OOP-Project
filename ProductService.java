import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) {
        try {
            productDAO.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public boolean deleteProductById(int id) {
        return productDAO.deleteProductById(id);
    }

    public boolean updateProduct(int id, String name, String category, int quantity, double price) {
        return productDAO.updateProduct(id, name, category, quantity, price);
    }
}
