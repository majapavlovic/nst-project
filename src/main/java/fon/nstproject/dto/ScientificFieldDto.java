/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto;

import lombok.Builder;

/**
 *
 * @author User
 */
@Builder
public record ScientificFieldDto(
        Long id,
        String scientificField) {

}
