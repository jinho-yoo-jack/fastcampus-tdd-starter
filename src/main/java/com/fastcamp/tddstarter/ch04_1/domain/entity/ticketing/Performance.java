package com.fastcamp.tddstarter.ch04_1.domain.entity.ticketing;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

import java.sql.Date;
import java.util.*;

@Entity
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Performance {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int round;
    @Column(nullable = false)
    private int type;
    @Column(nullable = false)
    private Date start_date;
    @Column(nullable = false, name = "is_reserve", columnDefinition = "varchar default 'disable'")
    private String isReserve;
    @OneToMany
    @JoinColumn(name = "performance_id")
    private List<PerformanceDiscountPolicy> policies = new ArrayList<>();
}
