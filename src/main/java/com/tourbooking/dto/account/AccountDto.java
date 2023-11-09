package com.tourbooking.dto.account;

import com.tourbooking.model.account.Role;
import com.tourbooking.model.tour.Tour;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

public class AccountDto implements Validator {
    @Email(message = "Thông tin email không tồn tại.")
    private String accountEmail;
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Mật khẩu chỉ chứa số, chữ thường, và chữ hoa, không chứa kí tự đặc biệt.")
    @Size(min=3, max=8, message = "Mật khẩu tối thiểu 3 kí tự, tối đa 8 kí tự")
//    @Column(columnDefinition = "varchar(8) default '123'")
    private String accountPassword;
    @NotEmpty(message = "Vui lòng nhập họ và tên")
//    @NotBlank(message = "Vui lòng không nhập khoảng trắng 2 đầu")
    @Size(min=5, max=45, message = "Số lượng kí tự tối thiểu là 5, tối đa 45")
    @Pattern(regexp = "^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+$",
            message = "Tên không chứa các số và các kí tự đặc biệt (@,#,$,^,&,*,<,>,...)")
    private String employeeName;
    @NotEmpty(message = "Vui lòng nhập số điện thoại")
//    @NotBlank(message = "Vui lòng không nhập khoảng trắng 2 đầu")
    @Pattern(regexp = "^(0[3|5|7|8|9])+([0-9]{8})$", message = "Vui lòng nhập đúng định dạng số điện thoại (10 chữ số).")
    private String employeePhone;

    private int employeeGender;
    private String employeeImg;
    @NotEmpty(message = "Vui lòng nhập số Căn cước công dân.")
//    @NotBlank(message = "Vui lòng không nhập khoảng trắng 2 đầu")
    @Pattern(regexp = "^([0-9]){12}$" , message = "Vui lòng nhập đúng định dạng căn cước công dân")
    private String employeeIdCard;
    public AccountDto(){}

    public AccountDto(String accountEmail, String accountPassword,
                      String employeeName, String employeePhone, int employeeGender,
                      String employeeImg, String employeeIdCard) {

        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeGender = employeeGender;
        this.employeeImg = employeeImg;
        this.employeeIdCard = employeeIdCard;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public int getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(int employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeImg() {
        return employeeImg;
    }

    public void setEmployeeImg(String employeeImg) {
        this.employeeImg = employeeImg;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

}
