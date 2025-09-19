package com.GolfWshAppp.Golfwash.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor

public class CardPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Setter
    @Getter
//    @NotBlank(message = "Card number is required")
//    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 digits")
    private String cardNumber;

    @Setter
    @Getter
//    @NotBlank(message = "Expiry date is required")
//    @Pattern(regexp = "\\d{2}/\\d{2}", message = "Expiry date must be in MM/YY format")
    private String expiryDate;

    @Setter
    @Getter
//    @NotBlank(message = "Name on card is required")
    private String nameOnCard;

    @Setter
    @Getter
//    @NotBlank(message = "Billing address is required")
    private String billingAddress;

    @Setter
    @Getter
//    @NotBlank(message = "ZIP code is required")
    private String zipCode;

    @Setter
    @Getter
//    @NotBlank(message = "CVV is required")
//    @Pattern(regexp = "\\d{3,4}", message = "CVV must be 3 or 4 digits")
    private String cvv;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "email",nullable = false)
//    private Customer customer;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final CardPaymentMethod instance = new CardPaymentMethod();

        public Builder cardNumber(String cardNumber) {
            instance.cardNumber = cardNumber;
            return this;
        }

        public Builder expiryDate(String expiryDate) {
            instance.expiryDate = expiryDate;
            return this;
        }

        public Builder nameOnCard(String nameOnCard) {
            instance.nameOnCard = nameOnCard;
            return this;
        }

        public Builder billingAddress(String billingAddress) {
            instance.billingAddress = billingAddress;
            return this;
        }

        public Builder zipCode(String zipCode) {
            instance.zipCode = zipCode;
            return this;
        }

        public Builder cvv(String cvv) {
            instance.cvv = cvv;
            return this;
        }

        public CardPaymentMethod build() {
            return instance;
        }
    }




}
