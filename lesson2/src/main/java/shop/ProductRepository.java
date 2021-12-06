package shop;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * Класс репозитория
 */
@Component
public class ProductRepository {

    private List<Product> productList;

    /**
     * Инициализируем репозиторий, наполняя продуктами
     */
    @PostConstruct
    public void init() {
        this.productList = List.of(
                new Product(1, "Процессор", 100),
                new Product(2, "Модуль памяти", 50),
                new Product(3, "Видеокарта", 1000),
                new Product(4, "Блок питания", 30),
                new Product(5, "Мышь", 10)
        );
    }

    /**
     * Позволяет получить один товар по id
     *
     * @param id товара
     * @return товар или пустой Optional
     */
    public Optional<Product> findProductById(Integer id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    /**
     * Позволяет получить весь список продуктов
     *
     * @return список продуктов
     */
    public List<Product> getProductList() {
        return List.copyOf(productList);
    }
}
