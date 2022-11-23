package com.nbs.bia.hackathon.gamification.controller;

import com.nbs.bia.hackathon.gamification.dto.CreateEventRequest;
import com.nbs.bia.hackathon.gamification.dto.GoalsResponse;
import com.nbs.bia.hackathon.gamification.dto.PointsResponse;
import com.nbs.bia.hackathon.gamification.service.GamificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/events", consumes = "application/json", produces = "application/json")
    public void createEvents(@RequestBody final CreateEventRequest createEventRequest){
        gamificationService.createEvents(createEventRequest);
    }

    @GetMapping(value = "/points/{customerNumber}", produces = "application/json")
    public ResponseEntity<PointsResponse> getPoints(@PathVariable String customerNumber) {
        return new ResponseEntity<PointsResponse> (gamificationService.getPoints(customerNumber), HttpStatus.OK);
    }
}
