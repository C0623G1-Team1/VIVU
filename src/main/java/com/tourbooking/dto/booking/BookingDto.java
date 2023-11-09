package com.tourbooking.dto.booking;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingDto implements Validator {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String date;
    private int adultQuantity;
    private int childrenQuantity;
    private String customerIdCard;
    private String promotionCode;
    private boolean isDeleted;
    private int tourId;

    public BookingDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//        return LocalDate.parse(date,dateTimeFormatter).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(int childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookingDto bookingDto=(BookingDto) target;
        if((bookingDto.getAdultQuantity()+ bookingDto.getChildrenQuantity())<=0){
            errors.rejectValue("adultQuantity",null, "Chưa nhập số lượng");
            errors.rejectValue("childrenQuantity",null, "Chưa nhập số lượng");
        }

        if(bookingDto.getName()==null||bookingDto.getName().equals("")||bookingDto.getName().matches("^[ ]*$")){
            errors.rejectValue("name", null,"Không được để trống");
        } else if(bookingDto.getName().matches("[0-9]*")){
            errors.rejectValue("name", null,"Tên không chứa số");
        }else if(!bookingDto.getName().matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+$")){
            errors.rejectValue("name", null,"Tên không chứa ký tự đặc biệt");
        }

        if(bookingDto.getEmail()==null||bookingDto.getEmail().equals("")||bookingDto.getEmail().matches("^[ ]*$")){
            errors.rejectValue("email", null,"Không được để trống");
        } else if(!bookingDto.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            errors.rejectValue("email",null,"Email không đúng");
        }

        if(bookingDto.getPhone()==null||bookingDto.getPhone().equals("")||bookingDto.getPhone().matches("^[ ]*$")){
            errors.rejectValue("phone", null,"Không được để trống");
        } else if(bookingDto.getPhone().matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]*")){
            errors.rejectValue("phone",null,"Số điện thoại không có chữ");
        } else if(!bookingDto.getPhone().matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")){
            errors.rejectValue("phone",null,"Số điện thoại không đúng");
        }

        if(bookingDto.getCustomerIdCard()==null||bookingDto.getCustomerIdCard().equals("")||bookingDto.getCustomerIdCard().matches("^[ ]*$")){
            errors.rejectValue("customerIdCard", null,"Không được để trống");
        } else if(bookingDto.getCustomerIdCard().matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]*")){
            errors.rejectValue("customerIdCard",null,"Số căn cước công dân không có chữ");
        } else if(!bookingDto.getCustomerIdCard().matches("^[0-9]{12}$")){
            errors.rejectValue("customerIdCard",null,"Số căn cước công dân không đúng");
        }
    }
}
