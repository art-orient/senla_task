package com.art.senla.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "products")
public class Product {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "status")
    private Status status;
    @Column(name = "created_at")
    private LocalDateTime createdDate;
}
