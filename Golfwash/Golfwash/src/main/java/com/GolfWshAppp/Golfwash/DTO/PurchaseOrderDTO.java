package com.GolfWshAppp.Golfwash.DTO;

import com.GolfWshAppp.Golfwash.model.CardPaymentMethod;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PurchaseOrderDTO {
    private CardPaymentMethodDTO cardPaymentMethodDTO;

    @Pattern(regexp = "^(Exterior Only|Full CarWash)$", message = "Choose between a Full CarWash and an exterior only wash")
    private String TypeOfWash;
    private double basePrice;
    private double distanceKm;
    private double extraCharge;
    private double totalPrice;
    public  double UserLat;
    public  double UserLong;


}
