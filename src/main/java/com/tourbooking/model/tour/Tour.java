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
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private int id;

    private String tourName;

    @Column(columnDefinition = "LONGTEXT")
    private String tourDescription;

    private int tourAvailableSeat;

    @Column(columnDefinition = "LONGTEXT")
    private String tourImage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private Date endDate;

    @Column(columnDefinition = "bit(1) default 0")
    private boolean isDeleted;

    private Long adultPrice;
    private Long childPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private Set<Booking> booking;

}
