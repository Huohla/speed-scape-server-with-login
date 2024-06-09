package com.tfc.repositories;

import com.tfc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByCategoryAndIdNot(String category, UUID productId);

    List<Product> findFirst4ByOrderByPriceAsc();
}
