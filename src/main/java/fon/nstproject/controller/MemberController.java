/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.member.MemberRequestDto;
import fon.nstproject.dto.member.MemberResponseDto;
import fon.nstproject.service.MemberService;
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
@RequestMapping("nst/api/v1/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> save(@Valid @RequestBody MemberRequestDto dto) throws Exception {
        MemberResponseDto res = memberService.save(dto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponseDto> getById(@PathVariable Long id) throws Exception {
        MemberResponseDto res = memberService.getById(id);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    @PatchMapping
    public ResponseEntity<MemberResponseDto> update(@Valid @RequestBody MemberRequestDto dto) throws Exception {
        MemberResponseDto res = memberService.update(dto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        memberService.deleteById(id);
        return new ResponseEntity<>("Member removed!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAll() throws Exception {
        List<MemberResponseDto> res = memberService.getAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
