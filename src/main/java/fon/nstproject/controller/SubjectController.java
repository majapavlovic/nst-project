/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.subject.SubjectRequestDto;
import fon.nstproject.dto.subject.SubjectResponseDto;
import fon.nstproject.service.SubjectService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/nst/api/v1/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDto> save(@Valid @RequestBody SubjectRequestDto subjectDto) throws Exception {
        SubjectResponseDto subDto = subjectService.save(subjectDto);
        return new ResponseEntity<>(subDto, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<SubjectResponseDto>> getAll() {
        List<SubjectResponseDto> subjects = subjectService.getAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<SubjectResponseDto> getById(@PathVariable Long id) throws Exception {
        SubjectResponseDto subject = subjectService.getById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        subjectService.deleteById(id);
        return new ResponseEntity<>("Subject removed!", HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<SubjectResponseDto> update(@Valid @RequestBody SubjectRequestDto subjectDto) throws Exception {
        SubjectResponseDto subDto = subjectService.update(subjectDto);
        return new ResponseEntity<>(subDto, HttpStatus.OK);
    }
}
