package com.sparksupport.product_sales.service.sale;

import com.sparksupport.product_sales.model.sale.Sale;

import java.util.List;

public interface SaleService {

    Sale addSale(Sale sale);

    List<Sale> getSalesByProductId(Integer productId);

    List<Sale> getAllSales();

    void deleteSale(Integer saleId);
}