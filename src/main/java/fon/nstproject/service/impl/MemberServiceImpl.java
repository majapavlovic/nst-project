/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.mapping.DtoEntityMapper;
import fon.nstproject.dto.member.MemberRequestDto;
import fon.nstproject.dto.member.MemberResponseDto;
import fon.nstproject.domain.Member;
import fon.nstproject.domain.AcademicTitle;
import fon.nstproject.domain.EducationTitle;
import fon.nstproject.domain.ScientificField;
import fon.nstproject.repository.AcademicTitleRepository;
import fon.nstproject.repository.EducationTitleRepositoy;
import fon.nstproject.repository.MemberRepository;
import fon.nstproject.repository.ScientificFieldRepository;
import fon.nstproject.service.MemberService;
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
public class MemberServiceImpl implements MemberService {

    @Autowired
    private DtoEntityMapper dtoEntityMapper;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AcademicTitleRepository academicRepository;
    @Autowired
    private EducationTitleRepositoy educationRepository;
    @Autowired
    private ScientificFieldRepository scientificRepository;

    @Override
    public MemberResponseDto save(MemberRequestDto t) throws Exception {
        Member member = dtoEntityMapper.mapRequestDtoToMember(t);
        member = setAdditionalFields(t, member);
        Member saved = memberRepository.save(member);
        return dtoEntityMapper.mapMemberToResponseDto(saved);
    }

    @Override
    public MemberResponseDto getById(Long id) throws Exception {
        Optional<Member> dbMember = memberRepository.findById(id);
        if (dbMember.isPresent()) {
            Member member = dbMember.get();
            return dtoEntityMapper.mapMemberToResponseDto(member);
        } else {
            throw new Exception("Member not found");
        }
    }

    @Override
    public MemberResponseDto update(MemberRequestDto t) throws Exception {
        Optional<Member> dbMember = memberRepository.findById(t.id());
        if (dbMember.isPresent()) {
            Member updated = dbMember.get();
            updated.setFirstName(t.firstName());
            updated.setLastName(t.lastName());
            updated = setAdditionalFields(t, updated);
            return dtoEntityMapper.mapMemberToResponseDto(memberRepository.save(updated));
        } else {
            throw new Exception("Member not found");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Member> dbMember = memberRepository.findById(id);
        if (dbMember.isPresent()) {
            memberRepository.delete(dbMember.get());
        } else {
            throw new Exception("Member removed!");
        }
    }

    @Override
    public List<MemberResponseDto> getAll() {
        return memberRepository
                .findAll()
                .stream().map(entity -> dtoEntityMapper.mapMemberToResponseDto(entity))
                .collect(Collectors.toList());
    }

    public Member setAdditionalFields(MemberRequestDto t, Member m) {
        if (t.academicTitleId() != null) {
            Optional<AcademicTitle> academic = academicRepository.findById(t.academicTitleId());
            if (academic.isPresent()) {
                m.setAcademicTitle(academic.get());
            }
        }

        if (t.educationTitleId() != null) {
            Optional<EducationTitle> education = educationRepository.findById(t.educationTitleId());
            if (education.isPresent()) {
                m.setEducationTitle(education.get());
            }
        }

        if (t.scientificFieldId() != null) {
            Optional<ScientificField> scientific = scientificRepository.findById(t.scientificFieldId());
            if (scientific.isPresent()) {
                m.setScientificField(scientific.get());
            }
        }
        return m;
    }
}
