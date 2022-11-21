package com.nbs.bia.hackathon.gamification.service;

import com.nbs.bia.hackathon.gamification.dto.EventName;
import com.nbs.bia.hackathon.gamification.dto.GoalsResponse;
import com.nbs.bia.hackathon.gamification.model.Goals;
import com.nbs.bia.hackathon.gamification.repository.GoalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GamificationService {
    private final GoalsRepository goalsRepository;

    public List<GoalsResponse> getGoals() {
        List<Goals> goals = goalsRepository.findAll();

        return goals.stream()
                .map(goal -> GoalsResponse.builder()
                        .goalName(goal.getGoalName())
                        .eventName(EventName.valueOf(goal.getEventName()))
                        .points(goal.getPoints())
                        .build())
                .collect(Collectors.toList());
    }
}
