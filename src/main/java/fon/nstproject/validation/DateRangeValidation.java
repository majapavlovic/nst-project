package fon.nstproject.validation;

import fon.nstproject.domain.DepartmentManager;
import fon.nstproject.dto.departmentManager.DeptManagerRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class DateRangeValidation implements ConstraintValidator<ValidDateRange, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof DeptManagerRequestDto) {
            DeptManagerRequestDto dm = (DeptManagerRequestDto) obj;
            LocalDate startDate = dm.startDate();
            LocalDate endDate = dm.endDate();
            if (startDate != null && endDate != null) {
                return startDate.isBefore(endDate);
            }
        }
        return true; 
    }
}
