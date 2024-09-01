/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.departmentSecretary;

import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.dto.member.MemberResponseDto;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public record DeptSecretaryResponseDto(
        Long id,
        MemberResponseDto member,
        DepartmentDto department,
        LocalDate startDate,
        LocalDate endDate) {
    
}
