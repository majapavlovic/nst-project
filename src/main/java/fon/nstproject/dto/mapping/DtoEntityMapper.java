/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.dto.mapping;

import fon.nstproject.dto.subject.SubjectRequestDto;
import fon.nstproject.dto.subject.SubjectResponseDto;
import fon.nstproject.dto.*;
import fon.nstproject.domain.*;
import fon.nstproject.dto.member.MemberRequestDto;
import fon.nstproject.dto.member.MemberResponseDto;
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

    public AcademicTitle mapDtoToAcademicTitle(AcademicTitleDto dto) {
        AcademicTitle title = new AcademicTitle();
        title.setId(dto.id());
        title.setAcademicTitle(dto.academicTitle());
        return title;
    }

    public AcademicTitleDto mapAcademicTitleToDto(AcademicTitle title) {
        AcademicTitleDto dto = new AcademicTitleDto(
                title.getId(),
                title.getAcademicTitle());
        return dto;
    }

    public EducationTitle mapDtoToEducationTitle(EducationTitleDto dto) {
        EducationTitle title = new EducationTitle();
        title.setId(dto.id());
        title.setEducationTitle(dto.educationTitle());
        return title;
    }

    public EducationTitleDto mapEducationTitleToDto(EducationTitle title) {
        EducationTitleDto dto = new EducationTitleDto(
                title.getId(),
                title.getEducationTitle());
        return dto;
    }

    public ScientificField mapDtoToScientificField(ScientificFieldDto dto) {
        ScientificField field = new ScientificField();
        field.setId(dto.id());
        field.setScientificField(dto.scientificField());
        return field;
    }
    
    public ScientificFieldDto mapScientificFieldToDto(ScientificField field) {
        ScientificFieldDto dto = new ScientificFieldDto(
                field.getId(),
                field.getScientificField());
        return dto;
    }

    public MemberResponseDto mapMemberToResponseDto(Member m) {
        MemberResponseDto dto = new MemberResponseDto(
                m.getId(),
                m.getFirstName(),
                m.getLastName(),
                mapAcademicTitleToDto(m.getAcademicTitle()),
                mapEducationTitleToDto(m.getEducationTitle()),
                mapScientificFieldToDto(m.getScientficField()));
        return dto;
    }

    public Member mapRequestDtoToMember(MemberRequestDto dto) {
        Member m = new Member();
        m.setId(dto.id());
        m.setFirstName(dto.firstName());
        m.setLastName(dto.lastName());
        return m;
    }

    public Member mapResponseDtoToMember(MemberResponseDto dto) {
        Member m = new Member();
        m.setId(dto.id());
        m.setFirstName(dto.firstName());
        m.setLastName(dto.lastName());
        m.setAcademicTitle(mapDtoToAcademicTitle(dto.academicTitle()));
        m.setEducationTitle(mapDtoToEducationTitle(dto.educationTitle()));
        m.setScientficField(mapDtoToScientificField(dto.scientficField()));
        return m;
    }

    public MemberRequestDto mapMemberToRequestDto(Member m) {
        MemberRequestDto dto = new MemberRequestDto(
                m.getId(),
                m.getFirstName(),
                m.getLastName(),
                m.getAcademicTitle().getId(),
                m.getEducationTitle().getId(),
                m.getScientficField().getId());
        return dto;
    }

}
