/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.DepartmentRepository;
import fon.nstproject.service.DomainService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DepartmentService implements DomainService<DepartmentDto, Long>{

    private DtoEntityMapper dtoEntityMapper;
    private DepartmentRepository departmentRepository;

    public DepartmentService(DtoEntityMapper dtoEntityMapper, DepartmentRepository departmentRepository) {
        this.dtoEntityMapper = dtoEntityMapper;
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public DepartmentDto save(DepartmentDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DepartmentDto getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DepartmentDto update(DepartmentDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapDepartmentToDto(entity))
                .collect(Collectors.toList());
    } 
    
}
