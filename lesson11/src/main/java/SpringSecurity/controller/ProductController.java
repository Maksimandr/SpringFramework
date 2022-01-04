package SpringSecurity.controller;

import SpringSecurity.model.Product;
import SpringSecurity.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String getAllProducts(Model model,
                                 @PageableDefault(size = 7) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        int totalPages = products.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("products", products);

        return "product_list";
    }

    @GetMapping("/products/info/{id}")
    public String getProductInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id).orElse(new Product()));
        return "product_info";
    }

    @GetMapping("/products/add")
    public String getProductAddFrom(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @GetMapping("/products/edit/{id}")
    public String getProductEditFrom(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id).orElse(new Product()));
        return "product_form";
    }

    @PostMapping("/products/add")
    public String saveProduct(@Valid Product product,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
