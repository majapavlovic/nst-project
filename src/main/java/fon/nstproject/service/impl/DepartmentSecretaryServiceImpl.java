/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.domain.Department;
import fon.nstproject.domain.DepartmentSecretary;
import fon.nstproject.domain.Member;
import fon.nstproject.dto.departmentSecretary.DeptSecretaryRequestDto;
import fon.nstproject.dto.departmentSecretary.DeptSecretaryResponseDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.exception.NotFoundException;
import fon.nstproject.repository.DepartmentRepository;
import fon.nstproject.repository.DepartmentSecretaryRepository;
import fon.nstproject.repository.MemberRepository;
import fon.nstproject.service.DepartmentSecretaryService;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DepartmentSecretaryServiceImpl implements DepartmentSecretaryService{
    
@Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DepartmentRepository deptRepository;
    @Autowired
    private DepartmentSecretaryRepository deptSecretaryRepository;

    @Override
    public DeptSecretaryResponseDto save(DeptSecretaryRequestDto t) throws Exception {
        DepartmentSecretary dm = dtoEntityMapper.mapRequestDtoToDeptSecretary(t);
        dm = setAdditionalFields(t, dm);
        DepartmentSecretary saved = deptSecretaryRepository.save(dm);
        return dtoEntityMapper.mapDeptSecretaryToResponseDto(saved);
    }

    @Override
    public DeptSecretaryResponseDto getById(Long id) throws Exception {
        Optional<DepartmentSecretary> dm = deptSecretaryRepository.findById(id);
        if (dm.isPresent()) {
            return dtoEntityMapper.mapDeptSecretaryToResponseDto(dm.get());
        } else {
            throw new NotFoundException("Department Secretary history", "id", id.toString());
        }
    }

    @Override
    public DeptSecretaryResponseDto update(DeptSecretaryRequestDto t) throws Exception {
        Optional<DepartmentSecretary> dm = deptSecretaryRepository.findById(t.id());
        if (dm.isPresent()) {
            DepartmentSecretary updated = dm.get();
            updated.setStartDate(t.startDate());
            updated.setEndDate(t.endDate());
            updated = setAdditionalFields(t, updated);
            return dtoEntityMapper.mapDeptSecretaryToResponseDto(deptSecretaryRepository.save(updated));
        } else {
            throw new NotFoundException("Department Secretary history", "id", t.id().toString());
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<DepartmentSecretary> dm = deptSecretaryRepository.findById(id);
        if (dm.isPresent()) {
            deptSecretaryRepository.delete(dm.get());
        } else {
            throw new NotFoundException("Department Secretary history", "id", id.toString());
        }
    }

    @Override
    public List<DeptSecretaryResponseDto> getAll() {
        return deptSecretaryRepository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapDeptSecretaryToResponseDto(entity))
                .collect(Collectors.toList());
    }

    public DepartmentSecretary setAdditionalFields(DeptSecretaryRequestDto t, DepartmentSecretary m) {
        if (t.memberId() != null) {
            Optional<Member> member = memberRepository.findById(t.memberId());
            if (member.isPresent()) {
                m.setMember(member.get());
            }
        }
        if (t.departmentId() != null) {
            Optional<Department> dept = deptRepository.findById(t.departmentId());
            if (dept.isPresent()) {
                m.setDepartment(dept.get());
            }
        }
        return m;
    }
}
