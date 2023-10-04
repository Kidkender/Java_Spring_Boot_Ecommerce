package vn.sparkminds.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.sparkminds.ecommerce.entities.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
