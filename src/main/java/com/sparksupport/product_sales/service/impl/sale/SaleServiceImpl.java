package com.sparksupport.product_sales.service.impl.sale;

import com.sparksupport.product_sales.exception.ResourceNotFoundException;
import com.sparksupport.product_sales.model.product.Product;
import com.sparksupport.product_sales.model.sale.Sale;
import com.sparksupport.product_sales.repository.product.ProductRepository;
import com.sparksupport.product_sales.repository.sale.SaleRepository;
import com.sparksupport.product_sales.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Override
    public Sale addSale(Sale sale) {
        Product product = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + sale.getProduct().getId()));

        if (product.getQuantity() < sale.getQuantity()) {
            throw new IllegalArgumentException("Not enough quantity in stock");
        }

        product.setQuantity(product.getQuantity() - sale.getQuantity());

        sale.setProduct(product);
        sale.setSaleDate(LocalDateTime.now());
        sale.setPriceAtSale(product.getPrice());

        productRepository.save(product);
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getSalesByProductId(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
        return saleRepository.findByProduct(product);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public void deleteSale(Integer saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id " + saleId));
        saleRepository.delete(sale);
    }
}