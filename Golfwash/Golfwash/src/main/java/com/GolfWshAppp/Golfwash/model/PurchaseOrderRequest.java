package com.GolfWshAppp.Golfwash.model;

import com.GolfWshAppp.Golfwash.DTO.CardPaymentMethodDTO;
import com.GolfWshAppp.Golfwash.DTO.CustomerDTO;
import com.GolfWshAppp.Golfwash.DTO.PurchaseOrderDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class PurchaseOrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private PurchaseOrderDTO purchaseOrderDTO;
//    private CardPaymentMethodDTO cardPaymentMethodDTO;
    private CustomerDTO customerDTO;
}
