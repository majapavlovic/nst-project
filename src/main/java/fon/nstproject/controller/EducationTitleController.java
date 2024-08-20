/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.EducationTitleDto;
import fon.nstproject.service.EducationTitleService;
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
@RequestMapping("nst/api/v1/education-title")
public class EducationTitleController {
    @Autowired
    private EducationTitleService educationTitleService;

   @GetMapping
    public ResponseEntity<List<EducationTitleDto>> getAll() {
        List<EducationTitleDto> titles = educationTitleService.getAll();
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationTitleDto> getById(@PathVariable Long id) throws Exception{
        EducationTitleDto title = educationTitleService.getById(id);
        return new ResponseEntity<>(title, HttpStatus.FOUND);
    }   

    @PostMapping
    public ResponseEntity<EducationTitleDto> save(@Valid @RequestBody EducationTitleDto dto) throws Exception {
        EducationTitleDto title = educationTitleService.save(dto);
        return new ResponseEntity<>(title, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<EducationTitleDto> update(@Valid @RequestBody EducationTitleDto dto) throws Exception {
        EducationTitleDto title = educationTitleService.update(dto);
        return new ResponseEntity<>(title, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        educationTitleService.deleteById(id);
        return new ResponseEntity<>("Education Title removed!", HttpStatus.OK);

    }
}
