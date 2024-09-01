/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.departmentManager;

import fon.nstproject.validation.ValidDateRange;
import java.time.LocalDate;
import lombok.Builder;

/**
 *
 * @author User
 */
@Builder
@ValidDateRange
public record DeptManagerRequestDto(
        Long id,
        Long memberId,
        Long departmentId,
        LocalDate startDate,
        LocalDate endDate) {
}
