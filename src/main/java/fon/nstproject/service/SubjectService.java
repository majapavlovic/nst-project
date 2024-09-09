/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fon.nstproject.service;

import fon.nstproject.dto.subject.SubjectRequestDto;
import fon.nstproject.dto.subject.SubjectResponseDto;
import java.util.List;

/**
 *
 * @author User
 */
public interface SubjectService extends DomainService<SubjectRequestDto, SubjectResponseDto, Long> {
    public List<SubjectResponseDto> getSubjectsByDepartment(Long departmentId);
}

