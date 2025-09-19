package com.GolfWshAppp.Golfwash.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PurchaseOrderId;


    @Pattern(regexp = "^(Exterior Only|Full CarWash)$", message = "Choose between a Full CarWash and an exterior only wash")
    private String TypeOfWash;
    private double basePrice;
    private double distanceKm;
    private double extraCharge;
    private double totalPrice;
    public  double UserLat;
    public  double UserLong;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id", referencedColumnName = "Id")
    private CardPaymentMethod cardPaymentMethod;
}
