package com.tourbooking.repository.image;

import com.tourbooking.model.tour.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IImageRepository extends JpaRepository<Image,Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from `image` where image.tour_id = :tourId",nativeQuery = true)
    public void deleteImageByTourId(int tourId);
}
