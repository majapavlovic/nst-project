/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.service.DepartmentService;
import fon.nstproject.service.DomainService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/nst/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService deptService;
  
       
    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getAll(){
        List<DepartmentDto> depts = deptService.getAll();
        return new ResponseEntity<>(depts, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto departmentDto)  throws Exception{
        DepartmentDto deptDto = deptService.save(departmentDto);
        return new ResponseEntity<>(deptDto, HttpStatus.CREATED);
    }    
    
    @PatchMapping
    public ResponseEntity<DepartmentDto> update(@Valid @RequestBody DepartmentDto departmentDto) throws Exception {
        DepartmentDto deptDto = deptService.update(departmentDto);
        return new ResponseEntity<>(deptDto, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delteById(@PathVariable Long id) throws Exception {
        deptService.deleteById(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }
    
}
 