/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.domain.Department;
import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.DepartmentRepository;
import fon.nstproject.service.DepartmentService;
import fon.nstproject.service.DomainService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private DtoEntityMapper dtoEntityMapper;
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DtoEntityMapper dtoEntityMapper, DepartmentRepository departmentRepository) {
        this.dtoEntityMapper = dtoEntityMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto save(DepartmentDto t) throws Exception {
        Optional<Department> dbDept = departmentRepository.findByName(t.getName());
        if (dbDept.isPresent()) {
            throw new Exception("Department already exists!");
        }
        Department dept = dtoEntityMapper.mapDtoToDepartment(t);
        dept = departmentRepository.save(dept);
        return dtoEntityMapper.mapDepartmentToDto(dept);
    }

    @Override
    public DepartmentDto getById(Long id) throws Exception {
        Optional<Department> dbDept = departmentRepository.findById(id);
        if (dbDept.isPresent()) {
            Department department = dbDept.get();
            return dtoEntityMapper.mapDepartmentToDto(department);
        } else {
            throw new Exception("Department not found");
        }
    }

    @Override
    public DepartmentDto update(DepartmentDto t) throws Exception {
        Optional<Department> dbDept = departmentRepository.findById(t.getId());
        if (dbDept.isPresent()) {
            Department updated = dbDept.get();
            updated.setName(t.getName());
            updated.setShortName(t.getShortName());
            return dtoEntityMapper.mapDepartmentToDto(departmentRepository.save(updated));
        } else {
            throw new Exception("Department not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            Department department = dept.get();
            departmentRepository.delete(department);
        } else {
            throw new Exception("Department not found");
        }
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapDepartmentToDto(entity))
                .collect(Collectors.toList());
    }

}
