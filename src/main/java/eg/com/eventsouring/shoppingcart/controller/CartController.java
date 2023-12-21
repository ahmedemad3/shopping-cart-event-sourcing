package eg.com.eventsouring.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eg.com.eventsouring.shoppingcart.model.Cart;
import eg.com.eventsouring.shoppingcart.model.CartEvent;
import eg.com.eventsouring.shoppingcart.service.CartEventService;
import eg.com.eventsouring.shoppingcart.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

	private final CartEventService cartEventService;
	private final CartService cartService;

	@Autowired
	public CartController(CartEventService cartEventService , CartService cartService) {
		this.cartEventService = cartEventService;
		this.cartService = cartService;
	}

	@GetMapping("/{customerId}/events")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CartEvent> getCartEvents(@PathVariable Long customerId) {
		return cartEventService.getCartEventsByCustomerId(customerId);
	}

	@PostMapping("/{customerId}/events")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCartEvent(@PathVariable Long customerId, @RequestBody CartEvent cartEvent) {
		cartEvent.setCustomerId(customerId);
		cartEventService.addCartEvent(cartEvent);
	}

	@GetMapping("/aggregation/{customerId}")
	public ResponseEntity<Cart> getCustomerCartWithAggregations(@PathVariable Long customerId) {
		Cart cart = cartEventService.getCustomerCartWithAggregations(customerId);
		if (cart != null) {
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Cart> getCustomerCart(@PathVariable Long customerId) {
		Cart cart = cartService.getCustomerCart(customerId);
		if (cart != null) {
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
