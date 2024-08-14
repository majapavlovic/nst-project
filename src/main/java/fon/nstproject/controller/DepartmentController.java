/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.service.DomainService;
import fon.nstproject.service.impl.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DomainService deptService;
    
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll(){
        List<DepartmentDto> depts = deptService.getAll();
        return new ResponseEntity<>(depts, HttpStatus.OK);
    }
    
    
}
