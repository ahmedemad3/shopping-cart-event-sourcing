package eg.com.eventsouring.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eg.com.eventsouring.shoppingcart.model.Cart;
import eg.com.eventsouring.shoppingcart.model.CartItem;
import eg.com.eventsouring.shoppingcart.repository.CartItemRepository;

@Service
public class CartService {

	private final CartItemRepository cartItemRepository;

	@Autowired
	public CartService(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;
	}
	
	public Cart getCustomerCart(Long customerId) {
		Cart cart = new Cart(customerId);
		List<CartItem> cartItems = cartItemRepository.findByCustomerId(customerId);
		cart.setCartItems(cartItems);
		return cart;
	}

}
