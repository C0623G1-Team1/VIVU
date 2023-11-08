package com.tourbooking.service.booking.impl;


import com.tourbooking.model.booking.Booking;
import com.tourbooking.repository.booking.IBookingRepository;
import com.tourbooking.service.booking.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService {
    @Autowired
    IBookingRepository repository;
    @Override
    public void createBooking(Booking booking) {
        repository.save(booking);
    }

    @Override
    public Page<Booking> showListBooking(Pageable pageable) {
        return repository.showList(pageable);
    }

    @Override
    public Booking findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteBlog(id);
    }


    @Override
    public Page<Booking> findByPhone(String phone, Pageable pageable) {
        return repository.findByPhone(phone, pageable);
    }

    @Override
    public Integer sumAdultQuantity(int id) {
        return repository.countQuantityAdult(id);
    }

    @Override
    public Integer sumChildrenQuantity(int id) {
        return repository.countQuantityChildren(id);
    }
}
