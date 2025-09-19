package com.GolfWshAppp.Golfwash.DTO;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerLoginDTO {

    private String UserName;
    private String Password;


}
