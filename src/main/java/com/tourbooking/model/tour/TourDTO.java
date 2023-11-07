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
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên không được chứa các ký tự đặc biệt (@ ; , . = - + , ….)")
    private String tourName;

    @NotEmpty
    private String tourDescription;

    @NotEmpty
    @Min(20)
    @Max(50)
    @Pattern(regexp = "^/d+{2}$", message = "Phải có tối thiểu 20 và tối đa 50 khách tham quan")
    private Integer tourAvailableSeat;

    @NotEmpty
    private List<String> imageUrls;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Thời gian khởi hành và kết thúc phải là ngày ở hiện tại hoặc tương lai")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Thời gian khởi hành và kết thúc phải là ngày ở hiện tại hoặc tương lai")
    private Date endDate;

    @NotEmpty
    @Pattern(regexp = "^/d+$", message = "Giá phải là số và không chứa các ký tự đặc biệt")
    private Long adultPrice;

    @NotEmpty
    @Pattern(regexp = "^/d+$", message = "Giá phải là số và không chứa các ký tự đặc biệt")
    private Long childPrice;
}
