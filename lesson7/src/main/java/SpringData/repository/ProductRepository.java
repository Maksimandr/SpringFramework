package SpringData.repository;

import SpringData.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCostIsGreaterThanEqual (Integer cost);

    List<Product> findAllByCostIsLessThanEqual (Integer cost);

    List<Product> findAllByCostIsBetween (Integer costMin, Integer costMax);
}
