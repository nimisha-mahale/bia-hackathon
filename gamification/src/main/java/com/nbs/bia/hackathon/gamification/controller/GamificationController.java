package com.nbs.bia.hackathon.gamification.controller;

import com.nbs.bia.hackathon.gamification.dto.GoalsResponse;
import com.nbs.bia.hackathon.gamification.service.GamificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GamificationController {
    private final GamificationService gamificationService;

    @GetMapping(value = "/goals", produces = "application/json")
    public List<GoalsResponse> getAllGoals() {
        return gamificationService.getGoals();
    }
}
