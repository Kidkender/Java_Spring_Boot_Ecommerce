package vn.sparkminds.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.sparkminds.tutorial.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{}

