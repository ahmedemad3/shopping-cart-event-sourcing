package eg.com.eventsouring.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	
	private Long itemId;
    private String itemName;
    private double price;
    private Integer quantity; 

}
