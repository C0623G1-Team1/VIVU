package com.tourbooking.service.tour;

import com.tourbooking.model.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITourService {
    List<Tour> showList();

    Page<Tour> showList(Pageable pageable);

    void create(Tour tour);

    Optional<Tour> findById(Integer id);

    void delete(Integer id);


    int showBookedTour(Integer id);

    Page<Tour> search(Pageable pageable, String name, Date startDate, Date endDate);

    List<Tour> searchTourByEmployee(int id);

}
