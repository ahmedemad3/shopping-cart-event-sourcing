package eg.com.eventsouring.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Cart {

	private Long customerId;
	private List<CartItem> cartItems;

	public Cart(Long customerId) {
		this.customerId = customerId;
		this.cartItems = new ArrayList<>();
	}

	public void processEvent(CartEvent cartEvent) {
		switch (cartEvent.getEventType()) {
		case "ADD_TO_CART":
			handleAddToCartEvent(cartEvent);
			break;
		case "REMOVE_FROM_CART":
			handleRemoveFromCartEvent(cartEvent);
			break;
		case "UPDATE_CART_ITEM_QUANTITY":
			handleUpdateCartItemQuantityEvent(cartEvent);
			break;
		case "CLEAR_CART":
			handleClearCartEvent(cartEvent);
			break;
		default:
			break;
		}
	}

	private void handleClearCartEvent(CartEvent cartEvent) {
		cartItems.clear();
	}

	private void handleUpdateCartItemQuantityEvent(CartEvent cartEvent) {
		int existingItemIndex = getCartIndexIfExists(cartEvent);
		log.info("handleUpdateCartItemQuantityEvent : existingItemIndex : " + existingItemIndex);
		if (existingItemIndex != -1) {
			CartItem cartItem = cartItems.get(existingItemIndex);
			if (cartItem != null) {
				cartItem.setQuantity(cartEvent.getQuantity());
				cartItem.setPrice(cartEvent.getPrice());
			}
		}
	}

	private void handleRemoveFromCartEvent(CartEvent cartEvent) {
		log.info("handleRemoveFromCartEvent : " + cartEvent.getEventType() + " , Item_ID : " + cartEvent.getItemId()
				+ " , Quantity : " + cartEvent.getQuantity());
		cartItems.removeIf(item -> item.getItemId().equals(cartEvent.getItemId()));
	}

	private void handleAddToCartEvent(CartEvent cartEvent) {
		int existingItemIndex = getCartIndexIfExists(cartEvent);
		log.info("handleAddToCartEvent : existingItemIndex : " + existingItemIndex);
		CartItem newItem = createCartItem(cartEvent);
		if (existingItemIndex == -1) {
			// not exists
			cartItems.add(newItem);
		} else {
			// exist and override
			cartItems.set(existingItemIndex, newItem);
		}
	}

	private CartItem createCartItem(CartEvent cartEvent) {
		return new CartItem(cartEvent.getItemId(), cartEvent.getItemName(), cartEvent.getPrice(),
				cartEvent.getQuantity());
	}

	private int getCartIndexIfExists(CartEvent cartEvent) {
		return IntStream.range(0, cartItems.size())
				.filter(i -> cartItems.get(i).getItemId().equals(cartEvent.getItemId())).findFirst().orElse(-1);
	}

}
