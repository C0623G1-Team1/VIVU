package com.tourbooking.repository.tour;

import com.tourbooking.model.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITourRepository extends JpaRepository<Tour, Integer> {
    @Query(nativeQuery = true, value = "update tour set is_deleted = 1 where tour_id =:param")
    Tour deleteTour(@Param("param") Integer id);

    @Query(nativeQuery = true, value = "select count(b.booking_id) \n" +
            "from booking b\n" +
            "join tour t on b.tour_id = t.tour_id\n" +
            "where t.tour_id = :id and b.booking_date >= curdate()")
    int showBookedTour(Integer id);
}
