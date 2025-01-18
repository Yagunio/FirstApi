package ru.front.product.service;

import org.springframework.stereotype.Service;
import ru.front.product.model.Product;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> findAllProduct();

    public Product saveProduct(Product product);

    public Product updateProduct(Product product);

    public void deleteProduct(Long id);
}
