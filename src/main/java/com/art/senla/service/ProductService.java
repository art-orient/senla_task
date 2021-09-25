package com.art.senla.service;

import com.art.senla.service.dto.ProductDto;
import lombok.Data;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getById(Long id);

    ProductDto getByName(String name);

    ProductDto add(ProductDto productDto);

    ProductDto update(ProductDto orderDto);

    void delete(Long id);
}
