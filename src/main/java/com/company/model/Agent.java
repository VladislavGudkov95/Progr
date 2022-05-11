package com.company.model;

import lombok.*;

import javax.persistence.*;

@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String type;

    @NonNull
    @Column
    private String mail;

    @NonNull
    @Column
    private String number;

    @Column(name = "log_company")
    private String logCompany;

    @NonNull
    @Column
    private String address;

    @NonNull
    @Column
    private int priority;

    @NonNull
    @Column
    private String director;

    @NonNull
    @Column(name = "INN")
    private long inn;

    @NonNull
    @Column(name = "KPP")
    private int kpp;

    //    @OneToMany(mappedBy = "agents")
//    Set<ProductSale> productSaleSet;
}
