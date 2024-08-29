/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto;

import fon.nstproject.enums.UserRole;


/**
 *
 * @author User
 */
public record SignUpUserDto(
        String username,
        String password,
        UserRole role) {

}
