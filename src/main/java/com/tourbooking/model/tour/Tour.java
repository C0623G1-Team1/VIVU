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
    @Column(columnDefinition = "LONGTEXT")
    private String tourImage;

    public Tour(){}

    public Tour(int id, String tourName, String tourDescription, int tourAvailableSeat,
                Date startDate, Date endDate, boolean isDeleted, Long adultPrice, Long childPrice,
                Account account, Set<Booking> booking, String tourImage) {
        this.id = id;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.tourAvailableSeat = tourAvailableSeat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDeleted = isDeleted;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.account = account;
        this.booking = booking;
        this.tourImage = tourImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public int getTourAvailableSeat() {
        return tourAvailableSeat;
    }

    public void setTourAvailableSeat(int tourAvailableSeat) {
        this.tourAvailableSeat = tourAvailableSeat;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Long adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Long getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Long childPrice) {
        this.childPrice = childPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public String getTourImage() {
        return tourImage;
    }

    public void setTourImage(String tourImage) {
        this.tourImage = tourImage;
    }
}
