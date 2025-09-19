package com.GolfWshAppp.Golfwash.controller;

import com.GolfWshAppp.Golfwash.DTO.CustomerDTO;
import com.GolfWshAppp.Golfwash.DTO.CustomerLoginDTO;
import com.GolfWshAppp.Golfwash.model.Customer;
import com.GolfWshAppp.Golfwash.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/CreateCustomer")
    public ResponseEntity<String>addCustomer(@RequestBody CustomerDTO customerDTO){
        String customer = customerService.addCustomer(customerDTO);
        return ResponseEntity.ok("Successfully registered ");
    }
    @GetMapping("/Login")
    public ResponseEntity<String>Login(@RequestBody CustomerLoginDTO customerLoginDTO){
        Optional<Boolean> customer = customerService.CustomerLogin(customerLoginDTO);
        return ResponseEntity.ok("Successful Login");
    }
}
