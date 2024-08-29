/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fon.nstproject.enums;

/**
 *
 * @author User
 */
public enum UserRole {
  ADMIN("admin"),
  USER("user");

  private String role;

  UserRole(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
