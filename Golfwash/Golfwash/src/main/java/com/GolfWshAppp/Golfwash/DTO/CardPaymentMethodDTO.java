package com.GolfWshAppp.Golfwash.DTO;

import com.GolfWshAppp.Golfwash.model.CardPaymentMethod;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;



public class CardPaymentMethodDTO {

    @Setter
    @Getter
    @NotBlank(message = "Card number is required")
    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 digits")
    private String cardNumber;

    @Setter
    @Getter
    @NotBlank(message = "Expiry date is required")
    @Pattern(regexp = "\\d{2}/\\d{2}", message = "Expiry date must be in MM/YY format")
    private String expiryDate;

    @Setter
    @Getter
    @NotBlank(message = "Name on card is required")
    private String nameOnCard;

    @Setter
    @Getter
    @NotBlank(message = "Billing address is required")
    private String billingAddress;

    @Setter
    @Getter
    @NotBlank(message = "ZIP code is required")
    private String zipCode;

    @Setter
    @Getter
    @NotBlank(message = "CVV is required")
    @Pattern(regexp = "\\d{3,4}", message = "CVV must be 3 or 4 digits")
    private String cvv;

    public CardPaymentMethod toEntity() {

//        String maskedCardNumber = "************" +getCardNumber().substring(12);
        return CardPaymentMethod.builder()
                .cardNumber(this.cardNumber)
                .expiryDate(this.expiryDate)
                .nameOnCard(this.nameOnCard)
                .billingAddress(this.billingAddress)
                .zipCode(this.zipCode)
                .cvv(this.cvv)
                .build();
    }




}
