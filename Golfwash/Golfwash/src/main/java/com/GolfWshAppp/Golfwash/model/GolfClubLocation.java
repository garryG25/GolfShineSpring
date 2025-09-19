package com.GolfWshAppp.Golfwash.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "Location")
public class GolfClubLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Address;
//    private double AddedAmount;

//    @OneToMany(mappedBy = "UserId",cascade = CascadeType.ALL,orphanRemoval = true)
//    @ToString.Exclude
//    private List<PurchaseOrder>purchaseOrders ;
}
