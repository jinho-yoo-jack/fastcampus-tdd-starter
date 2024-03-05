package com.fastcamp.tddstarter.ch04_1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(nullable = false, name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
    @LastModifiedDate
    @Column(nullable = true, name = "deleted_at")
    private LocalDateTime deletedAt;
}