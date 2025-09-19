package com.GolfWshAppp.Golfwash.repository;

import com.GolfWshAppp.Golfwash.model.GolfClubLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolfClubLocationRepo extends JpaRepository<GolfClubLocation,Long> {
}
