/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.departmentManager.DeptManagerRequestDto;
import fon.nstproject.dto.departmentManager.DeptManagerResponseDto;
import fon.nstproject.service.DepartmentManagerService;
import fon.nstproject.validation.ValidDateRange;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("nst/api/v1/deparment-manager-history")
public class DepartmentManagerController {

    @Autowired
    DepartmentManagerService service;

    @PostMapping
    public ResponseEntity<DeptManagerResponseDto> save(@Valid @RequestBody DeptManagerRequestDto dto) throws Exception {
        DeptManagerResponseDto res = service.save(dto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DeptManagerResponseDto> getById(@PathVariable Long id) throws Exception {
        DeptManagerResponseDto res = service.getById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DeptManagerResponseDto> update(@Valid @RequestBody DeptManagerRequestDto dto) throws Exception {
        DeptManagerResponseDto res = service.update(dto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Member removed!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DeptManagerResponseDto>> getAll() throws Exception {
        List<DeptManagerResponseDto> res = service.getAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
