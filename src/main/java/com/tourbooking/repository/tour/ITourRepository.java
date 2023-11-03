package com.tourbooking.repository.tour;

import com.tourbooking.model.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITourRepository extends JpaRepository<Tour, Integer> {

}
