package com.tourbooking.model.tour;

import com.tourbooking.model.account.Account;
import com.tourbooking.model.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Image> imageUrls;

    @Column(columnDefinition = "DATE")
    private Date startDate;

    @Column(columnDefinition = "DATE")
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
