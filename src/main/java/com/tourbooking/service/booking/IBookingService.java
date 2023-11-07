package com.tourbooking.service.booking;
import com.tourbooking.model.booking.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookingService {
    void createBooking(Booking booking);
    Page<Booking> showListBooking(Pageable pageable);

    Booking findById(int id);

    void delete(int id);

    Page<Booking> findByPhone(String phone,Pageable pageable);
}
