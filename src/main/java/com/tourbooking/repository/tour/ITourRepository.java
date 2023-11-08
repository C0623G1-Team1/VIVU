package com.tourbooking.repository.tour;

import com.tourbooking.model.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;

public interface ITourRepository extends JpaRepository<Tour, Integer> {
    @Query(value = "select * \n" +
            "from `tour` t\n" +
            "where `start_date` >= :startDate and `end_date` <= :endDate and `tour_name` like %:tourName% and `is_deleted` = 0",
    nativeQuery = true)
    Page<Tour> search(Pageable pageable,String tourName, Date startDate,Date endDate);
}
