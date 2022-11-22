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
@Builder(toBuilder = true)
@Table(name = "CUSTOMER_EVENTS")
public class CustomerEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "customer_number", length = 50, nullable = false)
    private String customerNumber;

    @Column(name = "goal_id")
    private Long goalId;
}
