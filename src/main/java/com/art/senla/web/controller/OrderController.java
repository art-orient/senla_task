package com.art.senla.web.controller;

import com.art.senla.service.OrderService;
import com.art.senla.service.ProductService;
import com.art.senla.service.dto.OrderDto;
import com.art.senla.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
public class OrderController {
    private final OrderService orderService;
    private static final String LOCATION = "Location";
    private static final String SEPARATOR = "/";

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ProductDto> getAll() {
        List<OrderDto> orderDtoList =  orderService.getAll();
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable @Min(1) Long id) {
        OrderDto orderDto = orderService.getById(id);
        return orderDto;
    }

    @GetMapping("/name/{name}")
    public OrderDto getByName(@PathVariable @NotBlank String name) {
        OrderDto orderDto = orderService.getByName(name);
        return orderDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto add(@RequestBody @Valid ProductDto productDto,
                                  HttpServletRequest request, HttpServletResponse response) {
        OrderDto addedOrderDto = orderService.add(productDto);
        response.addHeader(LOCATION, request.getRequestURL().append(SEPARATOR)
                .append(addedOrderDto.getId()).toString());
        return addedOrderDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@RequestBody @Valid OrderDto orderDto,
                                     @PathVariable @Min(1) Long id) {
        orderDto.setId(id);
        return orderService.update(orderDto);
    }
}
