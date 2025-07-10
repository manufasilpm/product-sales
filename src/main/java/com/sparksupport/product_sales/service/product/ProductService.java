package com.sparksupport.product_sales.service.product;

import com.sparksupport.product_sales.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductService {

    Page<Product> getAllProducts(Pageable pageable);

    Optional<Product> getProductById(Integer id);

    Product addProduct(Product product);

    Product updateProduct(Integer id, Product updatedProduct);

    void deleteProduct(Integer id);

    BigDecimal getTotalRevenue();

    BigDecimal getRevenueByProduct(Integer productId);
}