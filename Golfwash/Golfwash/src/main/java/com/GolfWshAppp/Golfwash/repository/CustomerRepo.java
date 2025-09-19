package com.GolfWshAppp.Golfwash.repository;

import com.GolfWshAppp.Golfwash.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Optional<Customer>findByUserName(String username);
//    Optional<Customer>findBypassword(String Password);

    static boolean existsByUserName(String userName) {
        return false;
    }

    static boolean existsByEmail(String email) {
        return false;
    }

}
