/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fon.nstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fon.nstproject.domain.AcademicTitleHistory;

/**
 *
 * @author User
 */
public interface AcademicTitleHistRepository extends JpaRepository<AcademicTitleHistory, Long>{
    
}
