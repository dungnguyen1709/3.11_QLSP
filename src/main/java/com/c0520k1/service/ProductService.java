package com.c0520k1.service;

import com.c0520k1.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findALlProduct();

    Product findById(int id);

    void save(Product product);

    void remove(int id);

    void update(int id, Product product);

}
