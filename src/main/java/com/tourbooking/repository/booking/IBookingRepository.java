package com.tourbooking.repository.booking;
import com.tourbooking.model.booking.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {
    Page<Booking> findByPhone(String phone, Pageable pageable);
    @Query("select b from Booking b where b.isDeleted= false")
    Page<Booking> showList(Pageable pageable);
    @Transactional
    @Modifying
    @Query("update Booking set isDeleted = true where id= :id")
    void deleteBlog(@Param("id") int id);
    @Query("select sum(b.adultQuantity) from Booking b where b.tour.id =:id")
    Integer countQuantityAdult(@Param("id") int id);

    @Query("select sum(b.childrenQuantity) from Booking b where b.tour.id =:id")
    Integer countQuantityChildren(@Param("id") int id);
}
