package com.tourbooking.repository.tour;

import com.tourbooking.model.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import java.util.List;

public interface ITourRepository extends JpaRepository<Tour, Integer> {
    @Query(nativeQuery = true, value = "select * from tour as t\n" +
            "join account as a on a.account_id = t.account_id\n" +
            "where t.account_id=:param")
    List<Tour> searchTourByEmployee(@Param("param") int id);

}
