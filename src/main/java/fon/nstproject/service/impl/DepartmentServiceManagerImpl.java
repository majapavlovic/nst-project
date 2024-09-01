/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.domain.Department;
import fon.nstproject.domain.DepartmentManager;
import fon.nstproject.domain.Member;
import fon.nstproject.dto.departmentManager.DeptManagerRequestDto;
import fon.nstproject.dto.departmentManager.DeptManagerResponseDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.exception.NotFoundException;
import fon.nstproject.repository.DepartmentManagerRepository;
import fon.nstproject.repository.DepartmentRepository;
import fon.nstproject.repository.MemberRepository;
import fon.nstproject.service.DepartmentManagerService;
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
public class DepartmentServiceManagerImpl implements DepartmentManagerService {

    @Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DepartmentRepository deptRepository;
    @Autowired
    private DepartmentManagerRepository deptManagerRepository;

    @Override
    public DeptManagerResponseDto save(DeptManagerRequestDto t) throws Exception {
        DepartmentManager dm = dtoEntityMapper.mapRequestDtoToDeptManager(t);
        dm = setAdditionalFields(t, dm);
        DepartmentManager saved = deptManagerRepository.save(dm);
        return dtoEntityMapper.mapDeptManagerToResponseDto(saved);
    }

    @Override
    public DeptManagerResponseDto getById(Long id) throws Exception {
        Optional<DepartmentManager> dm = deptManagerRepository.findById(id);
        if (dm.isPresent()) {
            return dtoEntityMapper.mapDeptManagerToResponseDto(dm.get());
        } else {
            throw new NotFoundException("Department manager history", "id", id.toString());
        }
    }

    @Override
    public DeptManagerResponseDto update(DeptManagerRequestDto t) throws Exception {
        Optional<DepartmentManager> dm = deptManagerRepository.findById(t.id());
        if (dm.isPresent()) {
            DepartmentManager updated = dm.get();
            updated.setStartDate(t.startDate());
            updated.setEndDate(t.endDate());
            updated = setAdditionalFields(t, updated);
            return dtoEntityMapper.mapDeptManagerToResponseDto(deptManagerRepository.save(updated));
        } else {
            throw new NotFoundException("Department manager history", "id", t.id().toString());
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<DepartmentManager> dm = deptManagerRepository.findById(id);
        if (dm.isPresent()) {
            deptManagerRepository.delete(dm.get());
        } else {
            throw new NotFoundException("Department manager history", "id", id.toString());
        }
    }

    @Override
    public List<DeptManagerResponseDto> getAll() {
        return deptManagerRepository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapDeptManagerToResponseDto(entity))
                .collect(Collectors.toList());
    }

    public DepartmentManager setAdditionalFields(DeptManagerRequestDto t, DepartmentManager m) {
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
