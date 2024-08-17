/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.subject;

import fon.nstproject.dto.DepartmentDto;

/**
 *
 * @author User
 */
public record SubjectResponseDto(
        Long id,
        String name,
        int espb,
        DepartmentDto department) {
}
