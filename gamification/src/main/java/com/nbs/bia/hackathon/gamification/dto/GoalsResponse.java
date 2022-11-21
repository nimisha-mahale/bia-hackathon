package com.nbs.bia.hackathon.gamification.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoalsResponse {
    private String goalName;
    private EventName eventName;
    private int points;
}
