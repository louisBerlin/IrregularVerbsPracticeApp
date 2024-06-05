package org.louis.backend.controller;


import lombok.RequiredArgsConstructor;
import org.louis.backend.model.Progression;
import org.louis.backend.repository.ProgressionRepository;
import org.louis.backend.service.ProgressionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progression")
@RequiredArgsConstructor
public class ProgressionController {

    final ProgressionService progressionService;

    @PostMapping("add")
    public void addProgression(String userId, long points) {
        progressionService.addProgression(userId, points);
    }

    @PostMapping("getAll")
    public List<Progression> getProgressions(@RequestBody String userId) {
        return progressionService.getProgressions(userId.replace("=", ""));
    }

    @PostMapping("last")
    public Progression getLastProgression(@RequestBody String userId) {
        return progressionService.getLastProgression(userId.replace("=", ""));
    }



}
