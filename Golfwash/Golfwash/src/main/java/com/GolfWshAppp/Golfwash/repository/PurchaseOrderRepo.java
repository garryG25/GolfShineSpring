package com.GolfWshAppp.Golfwash.repository;

import com.GolfWshAppp.Golfwash.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder,Long> {
}
