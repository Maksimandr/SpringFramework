package SpringRest2.controller;

import SpringRest2.dto.ProductShortDto;
import SpringRest2.model.Product;
import SpringRest2.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static SpringRest2.converter.ProductConverter.productShortDtoToProduct;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProductsWithCost(@RequestParam(required = false) Integer costMin,
                                             @RequestParam(required = false) Integer costMax,
                                             HttpServletResponse response) {
        if (costMin != null && costMax != null) {
            response.setHeader("cost-min", costMin.toString());
            response.setHeader("cost-max", costMax.toString());
            return productService.findAllByCostIsBetween(costMin, costMax);
        } else if (costMin != null) {
            response.setHeader("cost-min", costMin.toString());
            return productService.findAllByCostIsGreaterThanEqualOrderById(costMin);
        } else if (costMax != null) {
            response.setHeader("cost-max", costMax.toString());
            return productService.findAllByCostIsLessThanEqual(costMax);
        }
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductInfo(@PathVariable Long id) {
        Product product = productService.findById(id).orElse(null);
        HttpHeaders headers = new HttpHeaders();
        headers.add("product_id", id.toString());
        HttpStatus status;
        if (product == null) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(product, headers, status);
    }

    @PostMapping("/products/add")
    public Product saveProduct(@Valid @RequestBody ProductShortDto productShortDto) {
        Product product = productShortDtoToProduct(productShortDto);
        productService.save(product);
        return product;
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
