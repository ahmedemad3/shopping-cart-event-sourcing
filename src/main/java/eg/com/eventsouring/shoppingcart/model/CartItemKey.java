package eg.com.eventsouring.shoppingcart.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class CartItemKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3239005002932744476L;
	private Long customerId;
	private Long itemId;

}
