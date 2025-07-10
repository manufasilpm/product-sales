package com.sparksupport.product_sales.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparksupport.product_sales.model.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    private BigDecimal price;
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sale> sales = new ArrayList<>();

    // Optional: calculate revenue for each product
    public BigDecimal getRevenue() {
        return sales.stream()
                .map(sale -> sale.getPriceAtSale().multiply(BigDecimal.valueOf(sale.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}