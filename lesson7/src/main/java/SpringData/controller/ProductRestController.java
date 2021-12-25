package SpringData.controller;

import SpringData.model.Product;
import SpringData.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProductsWithCost(@RequestParam(required = false) Integer costMin,
                                             @RequestParam(required = false) Integer costMax) {
        if (costMin != null && costMax != null) {
            return productService.findAllByCostIsBetween(costMin, costMax);
        } else if (costMin != null) {
            return productService.findAllByCostIsGreaterThanEqualOrderById(costMin);
        } else if (costMax != null) {
            return productService.findAllByCostIsLessThanEqual(costMax);
        }
        return productService.findAll();
    }
}
