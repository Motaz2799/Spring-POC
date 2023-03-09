package com.motaz.internshipservice.service;

import com.motaz.internshipservice.dto.InternRequest;
import com.motaz.internshipservice.dto.InternResponse;
import com.motaz.internshipservice.model.Intern;
import com.motaz.internshipservice.repository.InternshipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class InternshipService {
    private final InternshipRepository internshipRepository;
    public void createIntern(InternRequest internRequest) {
        Intern intern = Intern.builder()
                .name(internRequest.getName())
                .salary(internRequest.getSalary())
                .build();

        internshipRepository.save(intern);
        log.info("intern {} created successfully", intern.getId());
    }

    public List<InternResponse> getAllInterns(){
        List<Intern> interns= internshipRepository.findAll();
        return interns.stream().map(this::mapToInternResponse).toList();

    }

    private InternResponse mapToInternResponse(Intern intern) {
        return InternResponse.builder().id(intern.getId())
                .name(intern.getName())
                .salary(intern.getSalary())
                .build();
    }
}
