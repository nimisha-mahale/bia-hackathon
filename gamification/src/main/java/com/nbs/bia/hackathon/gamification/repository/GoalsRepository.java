package com.nbs.bia.hackathon.gamification.repository;

import com.nbs.bia.hackathon.gamification.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Long> {
    Optional<Goals> findByEventName(String eventName);
}
