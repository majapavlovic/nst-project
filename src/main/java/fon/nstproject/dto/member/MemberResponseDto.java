/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.member;

import fon.nstproject.dto.AcademicTitleDto;
import fon.nstproject.dto.EducationTitleDto;
import fon.nstproject.dto.ScientificFieldDto;
import lombok.Builder;

/**
 *
 * @author User
 */
@Builder
public record MemberResponseDto(
        
        Long id,
        String firstName,
        String lastName,
        AcademicTitleDto academicTitle,
        EducationTitleDto educationTitle,
        ScientificFieldDto scientficField) {
    
}
