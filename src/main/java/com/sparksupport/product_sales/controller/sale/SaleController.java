package com.sparksupport.product_sales.controller.sale;

import com.sparksupport.product_sales.model.sale.Sale;
import com.sparksupport.product_sales.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    //GET all sales (admin only or public - based on requirement)
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    //GET all sales for a specific product
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Sale>> getSalesByProductId(@PathVariable Integer productId) {
        return ResponseEntity.ok(saleService.getSalesByProductId(productId));
    }

    //Add a new sale (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.addSale(sale), HttpStatus.CREATED);
    }

    //Delete sale by ID (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}