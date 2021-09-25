package com.art.senla.service.dto;

import com.art.senla.repository.entity.Status;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDto extends AbstractDto {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "status")
    private Status status;
    @Column(name = "created_at")
    private LocalDateTime createdDate;
}
