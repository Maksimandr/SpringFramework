package SpringSecurity.repository;

import SpringSecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("update Product p set p.title = ?1, p.cost = ?2 where p.id = ?3")
    void updateProductById(String title, Integer cost, Long userId);

    List<Product> findAllByCostIsGreaterThanEqual(Integer cost);

    List<Product> findAllByCostIsLessThanEqual(Integer cost);

    List<Product> findAllByCostIsBetween(Integer costMin, Integer costMax);

}
