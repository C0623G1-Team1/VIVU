package com.tourbooking.dto.account;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PasswordDto implements Validator {

    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Mật khẩu chỉ chứa số, chữ thường, và chữ hoa, không chứa kí tự đặc biệt.")
    @Size(min=3, max=8, message = "Mật khẩu tối thiểu 3 kí tự, tối đa 8 kí tự")
    private String oldPassword;
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Mật khẩu chỉ chứa số, chữ thường, và chữ hoa, không chứa kí tự đặc biệt.")
    @Size(min=3, max=8, message = "Mật khẩu tối thiểu 3 kí tự, tối đa 8 kí tự")
    private String newPassword;
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Mật khẩu chỉ chứa số, chữ thường, và chữ hoa, không chứa kí tự đặc biệt.")
    @Size(min=3, max=8, message = "Mật khẩu tối thiểu 3 kí tự, tối đa 8 kí tự")
    private String confirmPassword;
    public PasswordDto() {}
    public PasswordDto(String oldPassword, String newPassword, String confirmPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordDto passwordDto = (PasswordDto) target;
        if(!passwordDto.newPassword.equals(passwordDto.confirmPassword)) {
            errors.rejectValue("confirmPassword",
                    null,
                    "Mật khẩu không khớp nhau");
        }
    }
}
