package com.codegym.util;

import com.codegym.dto.CustomerDto.CustomerDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class DateTime18Util {
    public static void checkDate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate localDateNow = LocalDate.now();
        LocalDate birthday = null;
        int age = 0;
        try {
            birthday = customerDto.getCustomerBirth();
            age = Period.between(birthday, localDateNow).getYears();
            if (age < 18) {
                errors.rejectValue("customerBirth", "create.birthday", "Bạn phải trên 18 tuổi!");
            }
        } catch (Exception e) {
            errors.rejectValue("customerBirth", "create.birthday", "Vui lòng nhập đúng!");
        }
    }
}
