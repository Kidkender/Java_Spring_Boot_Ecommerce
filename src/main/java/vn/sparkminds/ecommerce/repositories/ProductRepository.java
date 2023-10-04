package vn.sparkminds.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.sparkminds.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{}

