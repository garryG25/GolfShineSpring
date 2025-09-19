package com.GolfWshAppp.Golfwash.service;

import com.GolfWshAppp.Golfwash.DTO.CustomerDTO;
import com.GolfWshAppp.Golfwash.DTO.CustomerLoginDTO;
import com.GolfWshAppp.Golfwash.model.Customer;
import com.GolfWshAppp.Golfwash.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public String addCustomer(CustomerDTO customerDTO){

        if (CustomerRepo.existsByEmail(customerDTO.getEmail())){
            return "Email address already exists";
        }
        if (CustomerRepo.existsByUserName(customerDTO.getUserName())){
            return "User Name already Exists";
        }

        Customer customer = new Customer();
        customer.setUserName(customerDTO.getUserName());
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        customer.setGolfClubLocation(customerDTO.getGolfClubLocation());
        customerRepo.save(customer);
        return "You have successfully registered";

    }
    public Optional<Boolean> CustomerLogin(CustomerLoginDTO customerLoginDTO){
        return
            Optional.of(customerRepo.findByUserName(customerLoginDTO.getUserName()).map(user -> user.getPassword().equals(customerLoginDTO.getPassword()))
                    .orElse(false));


    }
}
