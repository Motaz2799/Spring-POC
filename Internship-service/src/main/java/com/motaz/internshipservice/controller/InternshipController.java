package com.motaz.internshipservice.controller;

import com.motaz.internshipservice.dto.InternRequest;
import com.motaz.internshipservice.dto.InternResponse;
import com.motaz.internshipservice.service.InternshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interns")
@RequiredArgsConstructor
public class InternshipController {
    private final InternshipService internService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createIntern(@RequestBody InternRequest internRequest ){
        internService.createIntern(internRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InternResponse> getAllInterns() {
        return internService.getAllInterns();


    }

}
