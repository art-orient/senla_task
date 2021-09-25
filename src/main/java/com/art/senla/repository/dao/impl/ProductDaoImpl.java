package com.art.senla.repository.dao.impl;

import com.art.senla.repository.dao.ProductDao;
import com.art.senla.repository.entity.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDaoImpl implements ProductDao {
    private static final String GET_ALL = "FROM products";
    private static final String GET_BY_ID = "FROM products WHERE id = :id";
    private static final String GET_BY_NAME = "FROM products WHERE name = :name";
    private static final String DELETE = "DELETE products WHERE id = :id";
    private static final String ID = "id";
    private static final String NAME = "name";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery(GET_ALL, Product.class)
                .getResultList();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return entityManager.createQuery(GET_BY_ID, Product.class)
                .setParameter(ID, id)
                .getResultStream()
                .findAny();
    }

    @Override
    public Optional<Product> getByName(String name) {
        return entityManager.createQuery(GET_BY_NAME, Product.class)
                .setParameter(NAME, name)
                .getResultStream()
                .findAny();
    }

    @Override
    public Product add(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Override
    public boolean delete(Long id) {
        return entityManager.createQuery(DELETE)
                .setParameter(ID, id)
                .executeUpdate() == 1;
    }
}
