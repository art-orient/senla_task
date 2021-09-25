package com.art.senla.repository.dao;

import com.art.senla.repository.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> getAll();

    Optional<Product> getById(Long id);

    Optional<Product> getByName(String name);

    Product add(Product product);

    Product update(Product product);

    boolean delete(Long id);
}
