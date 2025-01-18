package ru.front.product.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.front.product.model.ClientProduct;
import ru.front.product.repository.ClientProductRepository;
import ru.front.product.service.ClientProductService;
import ru.front.product.service.ClientService;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientProductServiceImpl implements ClientProductService {
    private final ClientService clientService;
    private final ClientProductRepository clientProductRepository;

    @Override
    public List<ClientProduct> findAllClientProduct() {
        return clientProductRepository.findAll();
    }

    @Override
    public List<ClientProduct> findAllClientProductByClientId(Long clientId) {
        return clientProductRepository.findByClientId(clientId);
    }

    @Override
    public ClientProduct findClientProductByClientIdAndProductId(Long clientId, Long productId) {
        return clientProductRepository.findClientProductsByClientIdAndProductId(clientId, productId);
    }

    public String getClientInfo(Long clientId) {
        return clientService.getClientById(clientId);
    }

    @Override
    public ClientProduct saveClientProduct(ClientProduct clientProduct) {
        return clientProductRepository.save(clientProduct);
    }

    @Override
    public ClientProduct updateClientProduct(ClientProduct clientProduct) {
        return clientProductRepository.save(clientProduct);
    }

    @Override
    public void deleteClientProduct(ClientProduct clientProduct) {
        clientProductRepository.delete(clientProduct);
    }
}
