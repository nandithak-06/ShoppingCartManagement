package com.myproject.demo.service;
import com.myproject.demo.model.CartItem;
import com.myproject.demo.model.Product;
import com.myproject.demo.repository.CartRepository;
import com.myproject.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null && product.getStock() >= quantity) {
            CartItem item = new CartItem(product, quantity);
            cartRepository.save(item);
        }
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}
