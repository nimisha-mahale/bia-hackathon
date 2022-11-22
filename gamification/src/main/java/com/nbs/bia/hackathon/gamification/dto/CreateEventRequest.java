package com.nbs.bia.hackathon.gamification.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateEventRequest {
    private String customerNumber;
    private EventName action;
}
