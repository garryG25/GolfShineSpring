package com.GolfWshAppp.Golfwash.controller;

import com.GolfWshAppp.Golfwash.DTO.CardPaymentMethodDTO;
import com.GolfWshAppp.Golfwash.DTO.CustomerDTO;
import com.GolfWshAppp.Golfwash.DTO.PurchaseOrderDTO;
import com.GolfWshAppp.Golfwash.DTO.PurchaseOrderResponseDTO;
import com.GolfWshAppp.Golfwash.model.PurchaseOrder;
import com.GolfWshAppp.Golfwash.model.PurchaseOrderRequest;
import com.GolfWshAppp.Golfwash.service.PurchaseOderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PurchaseOrder")
public class PurchaseOrderController {
    private final PurchaseOderService purchaseOderService;

    public PurchaseOrderController(PurchaseOderService purchaseOderService) {
        this.purchaseOderService = purchaseOderService;
    }
    @PostMapping("/PurchaseOder")
    public ResponseEntity<PurchaseOrderResponseDTO>CreatePurchaseOrder(@Valid @RequestBody PurchaseOrderDTO purchaseOrderDTO){
 PurchaseOrderResponseDTO response = purchaseOderService.AddPurchaseOrder(purchaseOrderDTO);
        return ResponseEntity.ok(response);
    }
}
