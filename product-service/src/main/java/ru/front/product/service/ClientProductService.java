package ru.front.product.service;

import org.springframework.stereotype.Service;
import ru.front.product.model.ClientProduct;

import java.util.List;

@Service
public interface ClientProductService {
    List<ClientProduct> findAllClientProduct();

    List<ClientProduct> findAllClientProductByClientId(Long clientId);

    ClientProduct findClientProductByClientIdAndProductId(Long clientId, Long productId);

    public String getClientInfo(Long clientId);

    ClientProduct saveClientProduct(ClientProduct clientProduct);

    ClientProduct updateClientProduct(ClientProduct clientProduct);

    void deleteClientProduct(ClientProduct clientProduct);

}
