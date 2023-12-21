package eg.com.eventsouring.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eg.com.eventsouring.shoppingcart.model.Cart;
import eg.com.eventsouring.shoppingcart.model.CartEvent;
import eg.com.eventsouring.shoppingcart.repository.CartEventRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartEventService {

	private final CartEventRepository cartEventRepository;

	@Autowired
	public CartEventService(CartEventRepository cartEventRepository) {
		this.cartEventRepository = cartEventRepository;
	}

	public List<CartEvent> getCartEventsByCustomerId(Long customerId) {
		return cartEventRepository.findByCustomerIdOrderByEventDateAsc(customerId);
	}

	public void addCartEvent(CartEvent cartEvent) {
		cartEventRepository.save(cartEvent);
	}

	public Cart getCustomerCartWithAggregations(Long customerId) {
		List<CartEvent> cartEvents = getCartEventsByCustomerId(customerId);
		log.info("cartEvents : size " + cartEvents.size());
		Cart cart = new Cart(customerId);
		cartEvents.forEach(cartEvent -> cart.processEvent(cartEvent));
		return cart;
	}

}
