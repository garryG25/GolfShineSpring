package com.GolfWshAppp.Golfwash.service;

import com.GolfWshAppp.Golfwash.DTO.CardPaymentMethodDTO;
import com.GolfWshAppp.Golfwash.DTO.CustomerDTO;
import com.GolfWshAppp.Golfwash.DTO.PurchaseOrderDTO;
import com.GolfWshAppp.Golfwash.DTO.PurchaseOrderResponseDTO;
import com.GolfWshAppp.Golfwash.model.CardPaymentMethod;
import com.GolfWshAppp.Golfwash.model.GolfClubLocation;
import com.GolfWshAppp.Golfwash.model.PurchaseOrder;
import com.GolfWshAppp.Golfwash.repository.CardPaymentMethodRepo;
import com.GolfWshAppp.Golfwash.repository.PurchaseOrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PurchaseOderService {
    private final PurchaseOrderRepo purchaseOrderRepo;
    private final CardPaymentMethodRepo cardPaymentMethodRepo;
    public static final double GolfWash_LAT = -26.2041;
    public static final double GolfWash_LON = 28.0473;

    public PurchaseOderService(PurchaseOrderRepo purchaseOrderRepo, CardPaymentMethodRepo cardPaymentMethodRepo) {
        this.purchaseOrderRepo = purchaseOrderRepo;
        this.cardPaymentMethodRepo = cardPaymentMethodRepo;
    }
    public PurchaseOrderResponseDTO AddPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO){
//        Optional<CardPaymentMethod> cardPaymentMethod = cardPaymentMethodRepo.findBycardNumber(cardPaymentMethodDTO.getCardNumber());
        double distance = calculateDistance(GolfWash_LAT, GolfWash_LON,purchaseOrderDTO.getUserLat(), purchaseOrderDTO.getUserLong());
        double extraCharge = calculateExtraCharge(distance);
        double totalPrice = purchaseOrderDTO.getBasePrice() + extraCharge;
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setTypeOfWash(purchaseOrderDTO.getTypeOfWash());
        purchaseOrder.setDistanceKm(purchaseOrder.getDistanceKm());
        purchaseOrder.setBasePrice(purchaseOrder.getBasePrice());
        purchaseOrder.setExtraCharge(purchaseOrder.getExtraCharge());
        purchaseOrder.setTotalPrice(purchaseOrder.getTotalPrice());

//        CardPaymentMethod card = new CardPaymentMethod();
//        card.setCardNumber(cardPaymentMethodDTO.getCardNumber());
//        card.setExpiryDate(cardPaymentMethodDTO.getExpiryDate());
//        card.setZipCode(cardPaymentMethodDTO.getZipCode());
//        purchaseOrder.setCardPaymentMethod(card);
//         purchaseOrderRepo.save(purchaseOrder);

        return new PurchaseOrderResponseDTO(
                purchaseOrderDTO.getBasePrice(),
                distance,
                extraCharge,
                totalPrice,
                "Purchase Order Successful"
        );
    }
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 400;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
    public double calculateExtraCharge(double distanceKm) {
        int extraUnits = (int) Math.ceil(distanceKm / 5.0);
        return extraUnits * 50;
    }
}
