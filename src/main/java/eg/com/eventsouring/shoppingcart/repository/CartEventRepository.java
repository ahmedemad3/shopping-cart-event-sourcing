package eg.com.eventsouring.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.com.eventsouring.shoppingcart.model.CartEvent;

@Repository
public interface CartEventRepository extends JpaRepository<CartEvent, Long> {
    List<CartEvent> findByCustomerIdOrderByEventDateAsc(Long customerId);
}
