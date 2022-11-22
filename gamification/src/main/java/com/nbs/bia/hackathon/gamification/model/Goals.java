package com.nbs.bia.hackathon.gamification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "GOALS")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long goalId;

    @Column(name = "goal_name", length = 50, nullable = false)
    private String goalName;

    @Column(name = "event_name", length = 50, nullable = false)
    private String eventName;

    @Column(name = "points")
    private int points;
}
