package com.tourbooking.service.tour.impl;

import com.tourbooking.model.tour.Tour;
import com.tourbooking.repository.tour.ITourRepository;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TourService implements ITourService {
    @Autowired
    private ITourRepository tourRepository;

    @Override
    public List<Tour> showList() {
        return tourRepository.findAll();
    }

    @Override
    public Page<Tour> showList(Pageable pageable) {
        return tourRepository.findAll(pageable);
    }

    @Override
    public void create(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public Optional<Tour> findById(Integer id) {
        return tourRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        tourRepository.deleteById(id);
    }
}
