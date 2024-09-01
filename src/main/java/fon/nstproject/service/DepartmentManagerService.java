/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fon.nstproject.service;

import fon.nstproject.dto.departmentManager.DeptManagerRequestDto;
import fon.nstproject.dto.departmentManager.DeptManagerResponseDto;


/**
 *
 * @author User
 */
public interface DepartmentManagerService  extends DomainService
        <DeptManagerRequestDto, DeptManagerResponseDto, Long>{
    
}
