/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service;

import fon.nstproject.domain.Department;
import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.exception.NotFoundException;
import fon.nstproject.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author User
 */
@SpringBootTest
public class DepartmentServiceTest {

    @MockBean
    private DtoEntityMapper dtoEntityMapper;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @Test
    @DisplayName("Test save department")
    void testSaveNewDepartment() throws Exception {
        DepartmentDto dto = new DepartmentDto();
        dto.setName("Test Dept");

        Department dept = new Department();
        dept.setName("Test Dept");

        when(departmentRepository.findByName("Test Dept")).thenReturn(Optional.empty());
        when(dtoEntityMapper.mapDtoToDepartment(dto)).thenReturn(dept);
        when(departmentRepository.save(dept)).thenReturn(dept);
        when(dtoEntityMapper.mapDepartmentToDto(dept)).thenReturn(dto);

        DepartmentDto savedDept = departmentService.save(dto);

        assertNotNull(savedDept);
        assertEquals("Test Dept", savedDept.getName());
        verify(departmentRepository, times(1)).save(dept);
    }

    @Test
    @DisplayName("Test get all departments")
    void testGetAllDepartments() {
        Department dept1 = new Department(1L, "Test Department 1", "TD1");
        Department dept2 = new Department(2L, "Test Department 2", "TD2");
        List<Department> departments = new ArrayList<>();
        departments.add(dept1);
        departments.add(dept2);

        DepartmentDto deptDto1 = new DepartmentDto(1L, "Test Department 1", "TD1");
        DepartmentDto deptDto2 = new DepartmentDto(2L, "Test Department 2", "TD2");
        List<DepartmentDto> expectedDtos = new ArrayList<>();
        expectedDtos.add(deptDto1);
        expectedDtos.add(deptDto2);

        when(departmentRepository.findAll()).thenReturn(departments);

        when(dtoEntityMapper.mapDepartmentToDto(dept1)).thenReturn(deptDto1);
        when(dtoEntityMapper.mapDepartmentToDto(dept2)).thenReturn(deptDto2);

        List<DepartmentDto> actualDtos = departmentService.getAll();
        assertNotNull(actualDtos);
        assertEquals(2, actualDtos.size());
        assertEquals(expectedDtos, actualDtos);

        verify(departmentRepository, times(1)).findAll();
        verify(dtoEntityMapper, times(1)).mapDepartmentToDto(dept1);
        verify(dtoEntityMapper, times(1)).mapDepartmentToDto(dept2);
    }

    @Test
    @DisplayName("Test delete department by ID")
    void testDeleteDepartmentById() throws Exception {
        long id = 1L;
        Department department = new Department(id, "Test department", "TD");
        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
       departmentService.deleteById(id);
        verify(departmentRepository, times(1)).delete(department);
    }

    @Test
    @DisplayName("Get department by id")
    void testGetDepartmentById() throws Exception {
        long id = 1L;
        Department department = new Department(id, "Test department", "TD");
        DepartmentDto dto = new DepartmentDto(id, "Test department", "TD");

        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
        when(dtoEntityMapper.mapDepartmentToDto(department)).thenReturn(dto);

        DepartmentDto departmentDto = departmentService.getById(id);

        assertNotNull(departmentDto, "DepartmentDto should not be null");
        assertEquals(id, departmentDto.getId(), "Department ID should match");
        assertEquals("Test department", departmentDto.getName(), "Department name should match");
        assertEquals("TD", departmentDto.getShortName(), "Department short name should match");

        verify(departmentRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Get department by id - failure")
    void getDepartmentByIdFailureTest() {
        long id = 1L;

        assertThrows(NotFoundException.class, () -> {
            departmentService.getById(id);
        });
    }
}
