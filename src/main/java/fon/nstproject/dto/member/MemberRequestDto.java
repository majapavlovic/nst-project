/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.member;

import lombok.Builder;

/**
 *
 * @author User
 */
@Builder
public record MemberRequestDto(
        Long id,
        String firstName,
        String lastName,
        Long academicTitleId,
        Long educationTitleId,
        Long scientificFieldId) {

}
