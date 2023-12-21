package eg.com.eventsouring.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.com.eventsouring.shoppingcart.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    List<CartItem> findByCustomerId(Long customerId);


}
