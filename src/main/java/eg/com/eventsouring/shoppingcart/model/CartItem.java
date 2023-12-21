package eg.com.eventsouring.shoppingcart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
@IdClass(CartItemKey.class)
public class CartItem {
	
	public CartItem(Long itemId, String itemName, double price, Integer quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Id
	private Long customerId;
	@Id
	private Long itemId;
    private String itemName;
    private double price;
    private Integer quantity; 

}
