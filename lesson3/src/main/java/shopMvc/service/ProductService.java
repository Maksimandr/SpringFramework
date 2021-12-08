package shopMvc.service;

import org.springframework.stereotype.Service;
import shopMvc.dto.Product;
import shopMvc.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}

