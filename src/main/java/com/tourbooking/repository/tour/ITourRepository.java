package com.tourbooking.repository.tour;

import com.tourbooking.model.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;


public interface ITourRepository extends JpaRepository<Tour, Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update tour set is_deleted = 1 where tour_id =:param")
    void deleteTour(@Param("param") Integer id);

    @Query(nativeQuery = true, value = "select count(b.booking_id) \n" +
            "from booking b\n" +
            "join tour t on b.tour_id = t.tour_id\n" +
            "where t.tour_id = :id and b.booking_date >= curdate()")
    int showBookedTour(Integer id);


    @Query(value = "select * \n" +
            "from `tour` t\n" +
            "where `start_date` >= :startDate and `end_date` <= :endDate and `tour_name` like %:tourName% and `is_deleted` = 0",
    nativeQuery = true)
    Page<Tour> search(Pageable pageable, String tourName, Date startDate, Date endDate);

}
