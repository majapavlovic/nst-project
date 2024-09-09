/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.subject.SubjectResponseDto;
import fon.nstproject.domain.Subject;
import fon.nstproject.domain.Department;
import fon.nstproject.dto.subject.SubjectRequestDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.DepartmentRepository;
import fon.nstproject.repository.SubjectRepository;
import fon.nstproject.service.SubjectService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
    public SubjectResponseDto save(SubjectRequestDto t) throws Exception {
        Subject subject = dtoEntityMapper.mapRequestDtoToSubject(t);
        Optional<Department> department = departmentRepository.findById(t.departmentId());
        if(department.isPresent()) {
            Department dept = department.get();
            subject.setDepartment(dept);
        }
        Subject saved = subjectRepository.save(subject);              
        return dtoEntityMapper.mapSubjectToResponseDto(saved);
    }

    @Override
    public SubjectResponseDto getById(Long id) throws Exception {
        Optional<Subject> subject = subjectRepository.findById(id);
        if(subject.isPresent()) {
            Subject s = subject.get();
            return dtoEntityMapper.mapSubjectToResponseDto(s);
        } else {
            throw new Exception("Subject not found");
        }
    }

    @Override
    public SubjectResponseDto update(SubjectRequestDto t) throws Exception {
        Optional<Subject> dbSubject = subjectRepository.findById(t.id());
        if (dbSubject.isPresent()) {
            Subject toUpdate = dbSubject.get();
            toUpdate.setName(t.name());
            toUpdate.setEspb(t.espb());
            Optional<Department> tDepartment = departmentRepository.findById(t.departmentId());
            if(tDepartment.isPresent()) {
                toUpdate.setDepartment(tDepartment.get());
            }
            return dtoEntityMapper.mapSubjectToResponseDto(subjectRepository.save(toUpdate));
        } else {
            throw new Exception("Department not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Subject> dbSub = subjectRepository.findById(id);
        if(dbSub.isPresent()) {
            Subject s = dbSub.get();
            subjectRepository.delete(s);
        } else {
            throw new Exception("Subject not found");
        }
    }

    @Override
    public List<SubjectResponseDto> getAll() {
        return subjectRepository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapSubjectToResponseDto(entity))
                .collect(Collectors.toList());
    }
    
    
    public List<SubjectResponseDto> getSubjectsByDepartment(Long departmentId) {
        return subjectRepository
                  .findByDepartmentId(departmentId).stream().map(entity -> dtoEntityMapper.mapSubjectToResponseDto(entity))
                .collect(Collectors.toList());
    }
}
