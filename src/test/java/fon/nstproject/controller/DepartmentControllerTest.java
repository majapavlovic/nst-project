/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.dto.DepartmentDto;
import fon.nstproject.service.DepartmentService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 *
 * @author User
 */
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService deptService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetAll() throws Exception {
        DepartmentDto deptDto = new DepartmentDto();
        deptDto.setName("Software Engineering");
        deptDto.setShortName("SE");
        List<DepartmentDto> depts = List.of(deptDto);

        given(deptService.getAll()).willReturn(depts);

        mockMvc.perform(get("/nst/api/v1/department"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Software Engineering"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].shortName").value("SE"))
                .andDo(print());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetById() throws Exception {
        Long id = 1L;
        DepartmentDto deptDto = new DepartmentDto();
        deptDto.setName("Software Engineering");
        deptDto.setShortName("SE");
        given(deptService.getById(id)).willReturn(deptDto);

        mockMvc.perform(get("/nst/api/v1/department/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Software Engineering"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.shortName").value("SE"))
                .andDo(print());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testSave() throws Exception {
        DepartmentDto deptDto = new DepartmentDto();
        deptDto.setName("Test Department");
        deptDto.setShortName("TD");
        given(deptService.save(deptDto)).willReturn(deptDto);

        mockMvc.perform(post("/nst/api/v1/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test Department\",\"shortName\":\"TD\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Department"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.shortName").value("TD"))
                .andDo(print());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdate() throws Exception {
        DepartmentDto deptDto = new DepartmentDto();
        deptDto.setId(1L);
        deptDto.setName("Test department");
        deptDto.setShortName("TD");
        given(deptService.update(deptDto)).willReturn(deptDto);

        mockMvc.perform(put("/nst/api/v1/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test department\",\"shortName\":\"TD\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test department"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.shortName").value("TD"))
                .andDo(print());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteById() throws Exception {
        Long id = 1L;
        willDoNothing().given(deptService).deleteById(id);

        mockMvc.perform(delete("/nst/api/v1/department/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Department removed!"))
                .andDo(print());
    }
}
