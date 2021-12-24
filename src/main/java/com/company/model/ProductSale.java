package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_sale")
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "sale_date")
    private Date saleDate;

    @NonNull
    @Column(name = "count_product")
    private int countProduct;

//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "agent_id")
//    private Agent agent;
//
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private Product product;
}
