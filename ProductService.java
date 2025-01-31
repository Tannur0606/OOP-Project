import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    // Method to add a product using ProductDAO
    public void addProduct(Product product) {
        try {
            productDAO.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get all products using ProductDAO
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
