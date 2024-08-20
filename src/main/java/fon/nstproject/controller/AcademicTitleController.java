/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.AcademicTitleDto;
import fon.nstproject.service.AcademicTitleService;
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
@RequestMapping("nst/api/v1/academic-title")
public class AcademicTitleController {
    @Autowired
    private AcademicTitleService academicTitleService;

   @GetMapping
    public ResponseEntity<List<AcademicTitleDto>> getAll() {
        List<AcademicTitleDto> titles = academicTitleService.getAll();
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleDto> getById(@PathVariable Long id) throws Exception{
        AcademicTitleDto at = academicTitleService.getById(id);
        return new ResponseEntity<>(at, HttpStatus.FOUND);
    }   

    @PostMapping
    public ResponseEntity<AcademicTitleDto> save(@Valid @RequestBody AcademicTitleDto dto) throws Exception {
        AcademicTitleDto academicTitle = academicTitleService.save(dto);
        return new ResponseEntity<>(academicTitle, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<AcademicTitleDto> update(@Valid @RequestBody AcademicTitleDto dto) throws Exception {
        AcademicTitleDto academicTitle = academicTitleService.update(dto);
        return new ResponseEntity<>(academicTitle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        academicTitleService.deleteById(id);
        return new ResponseEntity<>("Academic Title removed!", HttpStatus.OK);

    }
}
