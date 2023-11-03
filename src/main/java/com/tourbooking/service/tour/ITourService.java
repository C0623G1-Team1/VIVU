package com.tourbooking.service.tour;

import com.tourbooking.model.tour.Tour;

import java.util.List;
import java.util.Optional;

public interface ITourService {
    List<Tour> showList();

    void create(Tour tour);

    Optional<Tour> findById(Integer id);

    void delete(Integer id);
}
