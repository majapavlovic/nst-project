/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.SubjectDto;
import fon.nstproject.domain.Subject;
import fon.nstproject.domain.Department;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.DepartmentRepository;
import fon.nstproject.repository.SubjectRepository;
import fon.nstproject.service.SubjectService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    
    @Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public SubjectDto save(SubjectDto t) throws Exception {
        Subject subject = dtoEntityMapper.mapDtoToSubject(t);
        Optional<Department> department = departmentRepository.findById(t.getDepartmentId());
        if(department.isPresent()) {
            Department dept = department.get();
            subject.setDepartment(dept);
        }
        Subject saved = subjectRepository.save(subject);
        System.out.println(saved);
                
        return dtoEntityMapper.mapSubjectToDto(saved);
    }

    @Override
    public SubjectDto getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubjectDto update(SubjectDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SubjectDto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
