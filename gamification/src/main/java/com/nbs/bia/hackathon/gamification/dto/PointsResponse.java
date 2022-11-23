package com.nbs.bia.hackathon.gamification.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PointsResponse {
    private long totalPoints;
    private long cumulativePoints;
}
