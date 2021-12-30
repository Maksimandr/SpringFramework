package SpringRest2.controller;

import SpringRest2.model.Product;
import SpringRest2.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CartRestController {

    private CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public List<Product> getCartProducts() {
        return cartService.getCartProducts();
    }

    @PostMapping("/cart/add")
    public List<Product> addProductInCart(@RequestBody Long id) {
        cartService.addProductById(id);
        return cartService.getCartProducts();
    }

    @DeleteMapping("/cart/remove/{id}")
    public ResponseEntity<Product> removeProduct(@PathVariable Long id) {
        cartService.removeProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}