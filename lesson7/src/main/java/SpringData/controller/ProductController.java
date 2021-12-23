package SpringData.controller;

import SpringData.model.Product;
import SpringData.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        List<Product> productsList = productService.findAll();
        Page<Product> productPage = new PageImpl<>(productsList, pageable, productsList.size());
        model.addAttribute("products", products);
        model.addAttribute("productPage", productPage);

        return "product_list";
    }

    @GetMapping("/products/min-max")
    public String getProductsWithCost(@RequestParam(required = false) Integer costMin,
                                      @RequestParam(required = false) Integer costMax,
                                      Model model) {
        if (costMin != null && costMax != null) {
            model.addAttribute("products", productService.findAllByCostIsBetween(costMin, costMax));
        } else if (costMin != null) {
            model.addAttribute("products", productService.findAllByCostIsGreaterThanEqualOrderById(costMin));
        } else if (costMax != null) {
            model.addAttribute("products", productService.findAllByCostIsLessThanEqual(costMax));
        } else {
            model.addAttribute("products", productService.findAll());
        }
        return "product_list";
    }

    @GetMapping("/products/{id}")
    public String getProductInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id).orElse(new Product()));
        return "product_info";
    }

    @GetMapping("/products/add")
    public String getProductAddFrom() {
        return "product_form";
    }

    @PostMapping("/products/add")
    public String saveProduct(@RequestParam String title,
                              @RequestParam Integer cost) {
        Product product = new Product();
        product.setTitle(title);
        product.setCost(cost);
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
