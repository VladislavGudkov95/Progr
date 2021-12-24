package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "products_short")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "name_product")
    private String name;

    @NonNull
    @Column(name = "type_product")
    private String type;

    @NonNull
    @Column(name = "articul")
    private int articul;

    @NonNull
    @Column(name = "count_employee")
    private int countEmployee;

    @NonNull
    @Column(name = "number_manufacture")
    private int numberManufacture;

    @NonNull
    @Column(name = "min_cost")
    private int minCost;

//    @OneToMany(mappedBy = "product_short")
//    Set<ProductSale> productSales;
}
