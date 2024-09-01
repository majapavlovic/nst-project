/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.departmentManager;

import fon.nstproject.domain.Member;
import fon.nstproject.domain.Department;
import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.dto.member.MemberResponseDto;
import java.time.LocalDate;

import lombok.Builder;

/**
 *
 * @author User
 */
@Builder
public record DeptManagerResponseDto(
        Long id,
        MemberResponseDto member,
        DepartmentDto department,
        LocalDate startDate,
        LocalDate endDate) {

}
