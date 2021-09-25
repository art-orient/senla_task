package com.art.senla.service;

import com.art.senla.service.dto.OrderDto;
import lombok.Data;

import java.util.List;

@Data
public interface OrderService {

    List<OrderDto> getAll();

    OrderDto getById(Long id);

    OrderDto add(OrderDto orderDto);

    OrderDto update(OrderDto orderDto);

    void delete(Long id);
}
