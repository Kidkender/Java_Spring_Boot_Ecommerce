package vn.sparkminds.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.sparkminds.ecommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

