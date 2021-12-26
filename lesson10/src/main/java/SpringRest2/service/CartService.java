package SpringRest2.service;

import SpringRest2.component.Cart;
import SpringRest2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private ProductService productService;
    private Cart cart;

    public CartService(ProductService productService, Cart cart) {
        this.productService = productService;
        this.cart = cart;
    }

    public List<Product> getCartProducts() {
        return cart.getProducts();
    }

    public void addProductById(Long id) {
        productService.findById(id).ifPresent(cart::addProduct);
    }

    public void removeProductById(Long id) {
        productService.findById(id).ifPresent(cart::removeProduct);
    }
}