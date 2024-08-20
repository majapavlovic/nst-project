/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.AcademicTitleDto;
import fon.nstproject.domain.AcademicTitle;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.AcademicTitleRepository;
import fon.nstproject.service.AcademicTitleService;
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
public class AcademicTitleServiceImpl implements AcademicTitleService {

    @Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private AcademicTitleRepository repository;

    @Override
    public AcademicTitleDto save(AcademicTitleDto t) throws Exception {
        AcademicTitle at = dtoEntityMapper.mapDtoToAcademicTitle(t);
        at = repository.save(at);
        return dtoEntityMapper.mapAcademicTitleToDto(at);
    }

    @Override
    public AcademicTitleDto getById(Long id) throws Exception {
        Optional<AcademicTitle> dbAt = repository.findById(id);
        if (dbAt.isPresent()) {
            AcademicTitle at = dbAt.get();
            return dtoEntityMapper.mapAcademicTitleToDto(at);
        } else {
            throw new Exception("Academic Title not found");
        }
    }

    @Override
    public AcademicTitleDto update(AcademicTitleDto t) throws Exception {
        Optional<AcademicTitle> dbAt = repository.findById(t.id());
        if (dbAt.isPresent()) {
            AcademicTitle updated = dbAt.get();
            updated.setAcademicTitle(t.academicTitle());
            return dtoEntityMapper.mapAcademicTitleToDto(repository.save(updated));
        } else {
            throw new Exception("Academic Title not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<AcademicTitle> dbAt = repository.findById(id);
        if (dbAt.isPresent()) {
            AcademicTitle found = dbAt.get();
            repository.delete(found);
        } else {
            throw new Exception("Error!");
        }
    }

    @Override
    public List<AcademicTitleDto> getAll() {
        return repository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapAcademicTitleToDto(entity))
                .collect(Collectors.toList());
    }

}
