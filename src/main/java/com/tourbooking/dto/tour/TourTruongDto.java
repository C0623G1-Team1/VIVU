package com.tourbooking.dto.tour;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TourTruongDto {
    private int id;
    private String tourName;
    private String tourDescription;
    private Long price;
    private int tourAvailableSeat;
    private String tourImage;
    private String startDate;
    private String endDate;
    private Long adultPrice;
    private Long childPrice;

    public TourTruongDto() {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getTourAvailableSeat() {
        return tourAvailableSeat;
    }

    public void setTourAvailableSeat(int tourAvailableSeat) {
        this.tourAvailableSeat = tourAvailableSeat;
    }

    public String getTourImage() {
        return tourImage;
    }

    public void setTourImage(String tourImage) {
        this.tourImage = tourImage;
    }

    public String getStartDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        return LocalDate.parse(startDate,dateTimeFormatter).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        return LocalDate.parse(endDate,dateTimeFormatter).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
}
