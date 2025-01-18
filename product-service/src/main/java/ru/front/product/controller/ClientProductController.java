package ru.front.product.controller;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.front.product.model.ClientProduct;
import ru.front.product.model.Product;
import ru.front.product.repository.ClientProductRepository;
import ru.front.product.service.ClientProductService;
import ru.front.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ClientProductController {
    private ClientProductService clientProductService;
    private ProductService productService;

    @GetMapping
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    @PostMapping("save_product")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "Продукт добавлен";
    }

    @PutMapping("update_product")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "Продукт обновлен";
    }

    @DeleteMapping("delete_product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Продукт удален";
    }

    @GetMapping("/client")
    public List<ClientProduct> getAllClientProducts() {
        return clientProductService.findAllClientProduct();
    }

    @GetMapping("/client/{clientId}")
    public List<ClientProduct> getClientProducts(@PathVariable Long clientId) {
        return clientProductService.findAllClientProductByClientId(clientId);
    }

    @GetMapping("/client/{clientId}/{product_id}")
    public ClientProduct getClientProduct(@PathVariable Long clientId, @PathVariable Long product_id) {
        return clientProductService.findClientProductByClientIdAndProductId(clientId, product_id);
    }

    @PostMapping("/assign")
    public String assignProductToClient(@RequestBody ClientProduct clientProduct) {
        // Проверяем, существует ли клиент
        String clientInfo = clientProductService.getClientInfo(clientProduct.getClientId());
        if (clientInfo == null) {
            return "Клиент не найден";
        }

        clientProductService.saveClientProduct(clientProduct);

        return "Продукт успешно выдан клиенту";
    }
}
