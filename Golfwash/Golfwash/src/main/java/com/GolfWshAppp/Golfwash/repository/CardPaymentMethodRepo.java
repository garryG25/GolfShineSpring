package com.GolfWshAppp.Golfwash.repository;

import com.GolfWshAppp.Golfwash.model.CardPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardPaymentMethodRepo extends JpaRepository<CardPaymentMethod,Long> {
    Optional<CardPaymentMethod>findBycardNumber(String cardNumber);
}
