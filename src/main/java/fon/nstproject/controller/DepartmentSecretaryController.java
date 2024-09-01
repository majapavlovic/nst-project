/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.departmentSecretary.DeptSecretaryRequestDto;
import fon.nstproject.dto.departmentSecretary.DeptSecretaryResponseDto;
import fon.nstproject.service.DepartmentSecretaryService;
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
@RequestMapping("nst/api/v1/department-secretary-history")
public class DepartmentSecretaryController {
    @Autowired
    DepartmentSecretaryService service;

    @PostMapping
    public ResponseEntity<DeptSecretaryResponseDto> save(@Valid @RequestBody DeptSecretaryRequestDto dto) throws Exception {
        DeptSecretaryResponseDto res = service.save(dto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DeptSecretaryResponseDto> getById(@PathVariable Long id) throws Exception {
        DeptSecretaryResponseDto res = service.getById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DeptSecretaryResponseDto> update(@Valid @RequestBody DeptSecretaryRequestDto dto) throws Exception {
        DeptSecretaryResponseDto res = service.update(dto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Member removed!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DeptSecretaryResponseDto>> getAll() throws Exception {
        List<DeptSecretaryResponseDto> res = service.getAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
