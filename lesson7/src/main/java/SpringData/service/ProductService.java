package SpringData.service;

import SpringData.model.Product;
import SpringData.repository.ProductRepository;
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

    public void save(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCostIsGreaterThanEqualOrderById(Integer cost) {
        return  productRepository.findAllByCostIsGreaterThanEqual(cost);
    }

    public List<Product> findAllByCostIsLessThanEqual(Integer cost) {
        return  productRepository.findAllByCostIsLessThanEqual(cost);
    }

    public List<Product> findAllByCostIsBetween(Integer costMin, Integer costMax) {
        return  productRepository.findAllByCostIsBetween(costMin, costMax);
    }
}
