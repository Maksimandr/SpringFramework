package shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс корзины
 */
@Component
@Scope("prototype")
public class Cart {

    private final ProductRepository productRepository;
    private final List<Product> products;

    public Cart(ProductRepository productRepository) {
        products = new ArrayList<>();
        this.productRepository = productRepository;
    }

    @Override
    public String toString() {
        return "shop.Cart{" +
                "products=" + products +
                '}';
    }

    /**
     * Метод добавляет товар в корзину по ID (если такой существует)
     * @param id товара
     */
    public void addProductById(Integer id) {
        productRepository.findProductById(id).ifPresent(products::add);
    }

    /**
     * Метод удаляет товар из корзины по ID (если такой существует)
     * @param id товара
     */
    public void deleteProductById(Integer id) {
        productRepository.findProductById(id).ifPresent(products::remove);
    }
}
