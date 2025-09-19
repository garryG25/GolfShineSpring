package com.GolfWshAppp.Golfwash.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User Table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    private String Password;
    public  double UserLat;
    public  double UserLong;

    @OneToMany(mappedBy = "PurchaseOrderId",cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private List<PurchaseOrder> purchaseOrders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Address",nullable = false)
    private GolfClubLocation golfClubLocation;


}
