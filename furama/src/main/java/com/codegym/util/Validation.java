package com.codegym.util;

import org.springframework.validation.Errors;

import java.time.LocalDate;

public class Validation {
    private static final String FACILITY_NAME_REGEX = "^([A-Z]\\w*)+(\\s[A-Z]\\w*)*$";

    public static void checkFacilityName(String field, String facilityName, Errors error) {
        if(facilityName.equals("")){
            error.rejectValue(field, "field.create", "Không được để trống");
        } else if (!facilityName.matches(FACILITY_NAME_REGEX)) {
            error.rejectValue(field, "field.create", "Nhập tên dịch vụ có chữ cái đầu viết hoa");
        }
    }

    public static void checkStartDate(String field, String startDate, Errors error) {
        LocalDate now = LocalDate.now();

        if (startDate.equals("")) {
            error.rejectValue(field, "startDate.create", "Không được để trống");
        } else {
            LocalDate startDate1 = LocalDate.parse(startDate);
            if (startDate1.compareTo(now) < 0) {
                error.rejectValue(field, "startDate.create", "Không nhập ngày quá khứ");
            }
        }
    }

    public static void checkEndDate(String field, String startDate, String endDate, Errors error) {
        if (endDate.equals("")) {
            error.rejectValue(field, "endDate.create", "Không được để trống");
        } else if (endDate.compareTo(startDate) < 0) {
            error.rejectValue(field, "endDate.create", "Ngày kết thúc không trước ngày bắt đầu");
        }
    }

    public static void checkDouble(String field, Double value, Errors error) {
        if (value == null) {
            error.rejectValue(field, "field", "Không được để trống!");
        } else if (value < 0) {
            error.rejectValue(field, "field", "Phải lớn hơn 0");
        }
    }

    public static void checkInteger(String field, String value, Errors error) {
        if (!value.matches("[0-9]+")) {
            error.rejectValue(field, "field.create", "Phải lớn hơn 0");
        }
    }
}
