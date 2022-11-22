package com.nbs.bia.hackathon.gamification.repository;

import com.nbs.bia.hackathon.gamification.model.CustomerEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEventsRepository extends JpaRepository<CustomerEvents, Long> {
}
