package com.tourbooking.model.tour;

import com.tourbooking.model.account.Account;
import com.tourbooking.model.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourDTO {
    private int id;
    private String tourName;
    private String tourDescription;
    private Integer tourAvailableSeat;
    private List<String> imageUrls;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private boolean isDeleted;
    private Long adultPrice;
    private Long childPrice;
    private int accountId;

}
