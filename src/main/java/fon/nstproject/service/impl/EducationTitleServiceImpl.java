/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.EducationTitleDto;
import fon.nstproject.domain.EducationTitle;
import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.repository.EducationTitleRepositoy;
import fon.nstproject.service.EducationTitleService;
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
public class EducationTitleServiceImpl implements EducationTitleService {

    @Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private EducationTitleRepositoy repository;

    @Override
    public EducationTitleDto save(EducationTitleDto t) throws Exception {
        EducationTitle title = dtoEntityMapper.mapDtoToEducationTitle(t);
        title = repository.save(title);
        return dtoEntityMapper.mapEducationTitleToDto(title);
    }

    @Override
    public EducationTitleDto getById(Long id) throws Exception {
        Optional<EducationTitle> dbEt = repository.findById(id);
        if (dbEt.isPresent()) {
            EducationTitle et = dbEt.get();
            return dtoEntityMapper.mapEducationTitleToDto(et);
        } else {
            throw new Exception("Education Title not found");
        }
    }

    @Override
    public EducationTitleDto update(EducationTitleDto t) throws Exception {
        Optional<EducationTitle> dbet = repository.findById(t.id());
        if (dbet.isPresent()) {
            EducationTitle updated = dbet.get();
            updated.setEducationTitle(t.educationTitle());
            return dtoEntityMapper.mapEducationTitleToDto(repository.save(updated));
        } else {
            throw new Exception("Education Title not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<EducationTitle> dbEt = repository.findById(id);
        if (dbEt.isPresent()) {
            EducationTitle found = dbEt.get();
            repository.delete(found);
        } else {
            throw new Exception("Error!");
        }
    }

    @Override
    public List<EducationTitleDto> getAll() {
        return repository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapEducationTitleToDto(entity))
                .collect(Collectors.toList());
    }

}
