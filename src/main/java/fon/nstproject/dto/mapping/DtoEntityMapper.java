/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.mapping;

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

    public SubjectDto mapSubjectToDto(Subject s) {
        SubjectDto subDto = new SubjectDto();
        subDto.setId(s.getId());
        subDto.setName(s.getName());
        subDto.setEspb(s.getEspb());
        subDto.setDepartmentId(s.getDepartment().getId());
        return subDto;
    }
    
    public Subject mapDtoToSubject(SubjectDto subDto) {
        Subject s = new Subject();
        s.setId(subDto.getId());
        s.setName(subDto.getName());
        s.setEspb(subDto.getEspb());
        return s;
    }
    
}
