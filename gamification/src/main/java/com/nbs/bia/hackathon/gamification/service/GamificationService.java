package com.nbs.bia.hackathon.gamification.service;

import com.nbs.bia.hackathon.gamification.dto.CreateEventRequest;
import com.nbs.bia.hackathon.gamification.dto.EventName;
import com.nbs.bia.hackathon.gamification.dto.GoalsResponse;
import com.nbs.bia.hackathon.gamification.exceptions.CreateEventsException;
import com.nbs.bia.hackathon.gamification.model.CustomerEvents;
import com.nbs.bia.hackathon.gamification.model.CustomerPoints;
import com.nbs.bia.hackathon.gamification.model.Goals;
import com.nbs.bia.hackathon.gamification.repository.CustomerEventsRepository;
import com.nbs.bia.hackathon.gamification.repository.CustomerPointsRepository;
import com.nbs.bia.hackathon.gamification.repository.GoalsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GamificationService {
    private final GoalsRepository goalsRepository;
    private final CustomerEventsRepository customerEventsRepository;
    private final CustomerPointsRepository customerPointsRepository;

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

    public void createEvents(final CreateEventRequest createEventRequest) {
        final Optional<Goals> goal = goalsRepository.findByEventName(createEventRequest.getAction().toString());
        if (goal.isPresent()) {
            final String customerNumber = createEventRequest.getCustomerNumber();
            final Long goalId = goal.get().getGoalId();
            final int points = goal.get().getPoints();

            saveCustomerEvents(goalId, customerNumber);
            saveCustomerPoints(customerNumber, points);
        } else {
            throw new CreateEventsException("Invalid Action");
        }
    }

    private void saveCustomerPoints(final String customerNumber, final int points) {
        Optional<CustomerPoints> customerPoints = customerPointsRepository.findByCustomerNumber(customerNumber);

        if (customerPoints.isPresent()) {
            customerPoints
                    .ifPresent(customerPoint -> updateTotalPoints(customerNumber, points, customerPoint));
        } else {
            saveTotalPoints(customerNumber, points);
        }
    }

    private void saveTotalPoints(String customerNumber, int points) {
        customerPointsRepository.save(CustomerPoints.builder()
                .customerNumber(customerNumber)
                .totalPoints((long) points)
                .cumulativePoints((long) points)
                .build());
        log.info("Saved customer {} with {} points successfully", customerNumber, points);
    }

    private void updateTotalPoints(String customerNumber, int points, CustomerPoints customerPoint) {
        long totalPoints = customerPoint.getTotalPoints();
        long cumulativePoints = customerPoint.getCumulativePoints();
        long updatedPoints;

        // If the limit has reached then reset the totalPoints
        if (totalPoints + points > 1000) {
            updatedPoints = (totalPoints + points) - 1000;
        } else {
            updatedPoints = (totalPoints + points);
        }

        customerPoint.setCumulativePoints(cumulativePoints + points);
        customerPoint.setTotalPoints(updatedPoints);

        customerPointsRepository.save(customerPoint);
        log.info("Updated customer {} with {} points successfully", customerNumber,
                updatedPoints);
    }

    private void saveCustomerEvents(Long goalId, String customerNumber) {
        customerEventsRepository.save(CustomerEvents.builder()
                .customerNumber(customerNumber)
                .goalId(goalId)
                .build());
        log.info("Saved customer events successfully");
    }
}
