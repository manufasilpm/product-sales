package com.sparksupport.product_sales.repository.sale;

import com.sparksupport.product_sales.model.product.Product;
import com.sparksupport.product_sales.model.sale.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findByProduct(Product product);
}