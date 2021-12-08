package SpringBoot.repository;

import SpringBoot.dto.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Coffee", 100));
        productList.add(new Product(2, "Tea", 70));
        productList.add(new Product(3, "Water", 50));
    }

    public List<Product> getAll() {
        return List.copyOf(productList);
    }

    public void save(Product product) {
        productList.add(product);
    }

    public Product findById(int id) {
        return productList.stream().filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
