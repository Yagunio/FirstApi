package ru.front.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.product.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
