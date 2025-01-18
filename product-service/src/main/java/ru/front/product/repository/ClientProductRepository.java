package ru.front.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.product.model.ClientProduct;

import java.util.List;

public interface ClientProductRepository extends JpaRepository<ClientProduct, Long> {
    List<ClientProduct> findByClientId(Long clientId);

    ClientProduct findClientProductsByClientIdAndProductId(Long clientId, Long productId);
}
