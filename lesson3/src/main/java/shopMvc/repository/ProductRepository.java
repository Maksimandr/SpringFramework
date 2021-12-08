package shopMvc.repository;

import org.springframework.stereotype.Component;
import shopMvc.dto.Product;

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
                new Product(1, "Процессор", 100f),
                new Product(2, "Модуль памяти", 50f),
                new Product(3, "Видеокарта", 1000f),
                new Product(4, "Блок питания", 30f),
                new Product(5, "Мышь", 10f)
        );
    }

    /**
     * Позволяет получить один товар по id
     *
     * @param id товара
     * @return товар или пустой Optional
     */
    public Optional<Product> findById(Integer id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    /**
     * Позволяет получить весь список продуктов
     *
     * @return список продуктов
     */
    public List<Product> getAll() {
        return List.copyOf(productList);
    }

    /**
     * Добавляет новый продукт
     *
     * @param product
     */
    public void save(Product product) {
        productList.add(product);
    }
}
