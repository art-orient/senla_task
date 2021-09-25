package com.art.senla.web.controller;

import com.art.senla.service.ProductService;
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
public class ProductController {
    private final ProductService productService;
    private static final String LOCATION = "Location";
    private static final String SEPARATOR = "/";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable @Min(1) Long id) {
        ProductDto productDto = productService.getById(id);
        return productDto;
    }

    @GetMapping("/name/{name}")
    public ProductDto getByName(@PathVariable @NotBlank String name) {
        ProductDto productDto = productService.getByName(name);
        return productDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto add(@RequestBody @Valid ProductDto productDto,
                                  HttpServletRequest request, HttpServletResponse response) {
        ProductDto addedProductDto = productService.add(productDto);
        response.addHeader(LOCATION, request.getRequestURL().append(SEPARATOR)
                .append(addedProductDto.getId()).toString());
        return addedProductDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto update(@RequestBody @Valid ProductDto productDto,
                                     @PathVariable @Min(1) Long id) {
        productDto.setId(id);
        return productService.update(productDto);
    }
}
