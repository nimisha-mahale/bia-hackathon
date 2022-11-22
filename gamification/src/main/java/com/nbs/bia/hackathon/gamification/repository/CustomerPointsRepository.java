package com.nbs.bia.hackathon.gamification.repository;

import com.nbs.bia.hackathon.gamification.model.CustomerPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerPointsRepository extends JpaRepository<CustomerPoints, Long> {
    Optional<CustomerPoints> findByCustomerNumber(String customerNumber);
}
