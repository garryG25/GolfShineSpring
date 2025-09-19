package com.GolfWshAppp.Golfwash.DTO;

import com.GolfWshAppp.Golfwash.model.GolfClubLocation;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {

    private String userName;
    private String email;
    private String Password;
    public  double UserLat;
    public  double UserLong;
    private GolfClubLocation golfClubLocation;

}
