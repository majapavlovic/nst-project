/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.departmentSecretary;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public record DeptSecretaryRequestDto(
        Long id,
        Long memberId,
        Long departmentId,
        LocalDate startDate,
        LocalDate endDate) {

}
