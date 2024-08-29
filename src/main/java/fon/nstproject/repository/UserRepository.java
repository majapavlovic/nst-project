/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.repository;
import fon.nstproject.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author User
 */
public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByUsername(String username);
}
