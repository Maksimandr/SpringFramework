package SpringSecurity.service;

import SpringSecurity.model.Product;
import SpringSecurity.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void updateProductById(Product product) {
        productRepository.updateProductById(product.getTitle(), product.getCost(), product.getId());
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCostIsGreaterThanEqualOrderById(Integer cost) {
        return productRepository.findAllByCostIsGreaterThanEqual(cost);
    }

    public List<Product> findAllByCostIsLessThanEqual(Integer cost) {
        return productRepository.findAllByCostIsLessThanEqual(cost);
    }

    public List<Product> findAllByCostIsBetween(Integer costMin, Integer costMax) {
        return productRepository.findAllByCostIsBetween(costMin, costMax);
    }
}
