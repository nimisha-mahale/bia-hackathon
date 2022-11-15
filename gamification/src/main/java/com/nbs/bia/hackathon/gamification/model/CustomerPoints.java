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
@Table(name="CUSTOMER_POINTS")
public class CustomerPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sys_id")
    private Long sysId;

    @Column(name="customer_number", length=50, nullable=false)
    private String customerNumber;

    @Column(name="total_points", nullable=false)
    private Long totalPoints;

    @Column(name="cumulative_points")
    private Long cumulativePoints;
}
