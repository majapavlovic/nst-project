/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.repository;

import fon.nstproject.domain.Department;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author User
 */
@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testFindByNameExists() {
        Department department = new Department();
        department.setName("Test Department");
        department.setShortName("TD");
        departmentRepository.save(department);
        Optional<Department> foundDept = departmentRepository.findByName("Test Department");
        assertTrue(foundDept.isPresent());
        assertEquals("Test Department", foundDept.get().getName());
    }

    @Test
    void testFindByNameDoesNotExist() {
        Optional<Department> foundDept = departmentRepository.findByName("Dept");

        assertFalse(foundDept.isPresent());
    }

    @Test
    void testSaveAndFindById() {

        Department department = new Department();
        department.setName("Test Department");
        department.setShortName("TD");
        Department savedDept = departmentRepository.save(department);
        Optional<Department> foundDept = departmentRepository.findById(savedDept.getId());

        assertTrue(foundDept.isPresent());
        assertEquals("Test Department", foundDept.get().getName());
        assertEquals("TD", foundDept.get().getShortName());
    }

    @Test
    void testDeleteDepartment() {
        Department department = new Department();
        department.setName("Test Department");
        department.setShortName("TD");
        Department savedDept = departmentRepository.save(department);

        departmentRepository.delete(savedDept);
        Optional<Department> foundDept = departmentRepository.findById(savedDept.getId());

        assertFalse(foundDept.isPresent());
    }
}
