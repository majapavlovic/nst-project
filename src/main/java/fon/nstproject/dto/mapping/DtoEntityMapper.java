/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.mapping;

import fon.nstproject.dto.subject.SubjectRequestDto;
import fon.nstproject.dto.subject.SubjectResponseDto;
import fon.nstproject.dto.*;
import fon.nstproject.domain.*;
import org.springframework.stereotype.Component;


/**
 *
 * @author User
 */
@Component
public class DtoEntityMapper {
    
    public DepartmentDto mapDepartmentToDto(Department dept) {
        DepartmentDto deptDto = new DepartmentDto();
        deptDto.setId(dept.getId());
        deptDto.setName(dept.getName());
        deptDto.setShortName(dept.getShortName());
        return deptDto;
    }

    public Department mapDtoToDepartment(DepartmentDto deptDto) {
        Department dept = new Department();
        dept.setId(deptDto.getId());
        dept.setName(deptDto.getName());
        dept.setShortName(deptDto.getShortName());
        return dept;
    }

    public SubjectResponseDto mapSubjectToResponseDto(Subject s) {
        SubjectResponseDto subDto = new SubjectResponseDto(
        s.getId(),
        s.getName(),
        s.getEspb(),
        mapDepartmentToDto(s.getDepartment()));
        return subDto;
    }
    
    public Subject mapRequestDtoToSubject(SubjectRequestDto subDto) {
        Subject s = new Subject();
        s.setId(subDto.id());
        s.setName(subDto.name());
        s.setEspb(subDto.espb());
        return s;
    }
    
     public Subject mapResponseDtoToSubject(SubjectResponseDto subDto) {
        Subject s = new Subject();
        s.setId(subDto.id());
        s.setName(subDto.name());
        s.setEspb(subDto.espb());
        s.setDepartment(mapDtoToDepartment(subDto.department()));
        return s;
    }
    
    public SubjectRequestDto mapSubjectToRequestDto(Subject s) {
        SubjectRequestDto requestDto = new SubjectRequestDto(
        s.getId(),
        s.getName(),
        s.getEspb(),
        s.getDepartment().getId());
        return requestDto;
    }
    
    
}
