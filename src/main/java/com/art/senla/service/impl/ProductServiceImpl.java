package com.art.senla.service.impl;

import com.art.senla.repository.dao.ProductDao;
import com.art.senla.repository.entity.Product;
import com.art.senla.service.ProductService;
import com.art.senla.service.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, ModelMapper modelMapper) {
        this.productDao = productDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        return productDao.getAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        return productDao.getById(id)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Incorrect ID = " + id");
    }

    @Override
    public ProductDto getByName(String name) {
        return productDao.getByName(name)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Incorrect name = " + name");
    }

    @Override
    public ProductDto add(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product addedProduct = productDao.add(product);
        return modelMapper.map(addedProduct, ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product productForUpdate = getById(productDto.getId());
        Product product = modelMapper.map(productDto, Product.class);
        Product updatedProduct = productDao.update(product);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public void delete(Long id) {
        if (!productDao.delete(id)) {
            throw new IllegalArgumentException("Incorrect ID = " + id);
        }
    }
}
