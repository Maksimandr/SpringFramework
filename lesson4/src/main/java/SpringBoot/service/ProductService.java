package SpringBoot.service;

import SpringBoot.dto.Product;
import SpringBoot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
