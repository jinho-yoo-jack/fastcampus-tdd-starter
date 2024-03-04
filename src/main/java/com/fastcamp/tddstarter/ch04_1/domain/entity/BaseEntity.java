package com.fastcamp.tddstarter.ch04_1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@MappedSuperclass
public class BaseEntity {
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(nullable = true, name = "deleted_at")
    private LocalDateTime deletedAt;
}