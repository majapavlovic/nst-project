/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.domain.ScientificField;
import fon.nstproject.dto.ScientificFieldDto;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.ScientificFieldRepository;
import fon.nstproject.service.ScientificFieldService;
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
public class ScientificFieldServiceImpl implements ScientificFieldService{

    @Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private ScientificFieldRepository repository;

    @Override
    public ScientificFieldDto save(ScientificFieldDto t) throws Exception {
        ScientificField field = dtoEntityMapper.mapDtoToScientificField(t);
        field = repository.save(field);
        return dtoEntityMapper.mapScientificFieldToDto(field);
    }

    @Override
    public ScientificFieldDto getById(Long id) throws Exception {
        Optional<ScientificField> dbField = repository.findById(id);
        if (dbField.isPresent()) {
            ScientificField field = dbField.get();
            return dtoEntityMapper.mapScientificFieldToDto(field);
        } else {
            throw new Exception("Scientific Field not found");
        }
    }

    @Override
    public ScientificFieldDto update(ScientificFieldDto t) throws Exception {
        Optional<ScientificField> dbField = repository.findById(t.id());
        if (dbField.isPresent()) {
            ScientificField updated = dbField.get();
            updated.setScientificField(t.scientificField());
            return dtoEntityMapper.mapScientificFieldToDto(repository.save(updated));
        } else {
            throw new Exception("Scientific Field not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<ScientificField> dbField = repository.findById(id);
        if (dbField.isPresent()) {
            ScientificField found = dbField.get();
            repository.delete(found);
        } else {
            throw new Exception("Error!");
        }
    }

    @Override
    public List<ScientificFieldDto> getAll() {
        return repository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapScientificFieldToDto(entity))
                .collect(Collectors.toList());
    }
    
}
