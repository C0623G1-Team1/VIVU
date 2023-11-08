package com.tourbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TourbookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourbookingApplication.class, args);

//        cách thức dùng để encode mật khẩu.
//        String oldPassword = "123";
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String afterEncod = bCryptPasswordEncoder.encode(oldPassword);


    }

}
