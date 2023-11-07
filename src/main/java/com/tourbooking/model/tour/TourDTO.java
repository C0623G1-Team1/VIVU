package com.tourbooking.model.tour;

import com.tourbooking.model.account.Account;
import com.tourbooking.model.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourDTO {
    private int id;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên không được chứa các ký tự đặc biệt (@ ; , . = - + , ….)")
    private String tourName;

    @NotEmpty(message = "Không được để trống")
    private String tourDescription;

    @NotNull(message = "Không được để trống")
    @Min(value = 20, message = "Tối thiểu 20 và tối đa 50 khách tham quan")
    @Max(value = 50, message = "Tối thiểu 20 và tối đa 50 khách tham quan")
    private Integer tourAvailableSeat;

//    @NotEmpty(message = "Không được để trống")
    private List<String> imageUrls;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Thời gian phải là ngày ở hiện tại hoặc tương lai")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Thời gian phải là ngày ở hiện tại hoặc tương lai")
    private Date endDate;

    @NotNull(message = "Không được để trống")
//    @Pattern(regexp = "^/d+$", message = "Giá phải là số và không chứa các ký tự đặc biệt")
    private Long adultPrice;

    @NotNull(message = "Không được để trống")
//    @Pattern(regexp = "^/d+$", message = "Giá phải là số và không chứa các ký tự đặc biệt")
    private Long childPrice;
}
