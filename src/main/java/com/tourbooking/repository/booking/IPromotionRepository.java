package com.tourbooking.repository.booking;

import com.tourbooking.model.booking.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    Promotion findByPromotionCode(String code);
}
