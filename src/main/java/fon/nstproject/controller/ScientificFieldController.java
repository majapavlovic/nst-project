/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.ScientificFieldDto;
import fon.nstproject.service.ScientificFieldService;
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
@RequestMapping("nst/api/v1/scientific-field")
public class ScientificFieldController {

    @Autowired
    private ScientificFieldService scientificFieldService;

    @GetMapping
    public ResponseEntity<List<ScientificFieldDto>> getAll() {
        List<ScientificFieldDto> fields = scientificFieldService.getAll();
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScientificFieldDto> getById(@PathVariable Long id) throws Exception {
        ScientificFieldDto field = scientificFieldService.getById(id);
        return new ResponseEntity<>(field, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ScientificFieldDto> save(@Valid @RequestBody ScientificFieldDto dto) throws Exception {
        ScientificFieldDto field = scientificFieldService.save(dto);
        return new ResponseEntity<>(field, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<ScientificFieldDto> update(@Valid @RequestBody ScientificFieldDto dto) throws Exception {
        ScientificFieldDto field = scientificFieldService.update(dto);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        scientificFieldService.deleteById(id);
        return new ResponseEntity<>("Education Title removed!", HttpStatus.OK);

    }
}
