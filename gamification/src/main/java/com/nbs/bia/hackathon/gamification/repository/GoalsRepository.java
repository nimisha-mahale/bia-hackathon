package com.nbs.bia.hackathon.gamification.repository;

import com.nbs.bia.hackathon.gamification.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goals, Long> {
}
