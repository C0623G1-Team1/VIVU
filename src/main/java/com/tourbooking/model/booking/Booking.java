package com.tourbooking.model.booking;

import com.tourbooking.model.tour.Tour;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_phone", columnDefinition = "varchar(10)")
    private String phone;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "booking_date")
    private String date;
    @Column(name = "adult_quantity")
    private Integer adultQuantity;
    @Column(name = "children_quantity")
    private Integer childrenQuantity;

    @Column(columnDefinition = "varchar(12)")
    private String customerIdCard;
    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
    private Promotion promotion;
    @Column(columnDefinition = "bit(1) default 0",name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne()
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id")
    private Tour tour;

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(Integer adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(Integer childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
