package com.c0520k1.service;

import com.c0520k1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

  private  static List<Product> products;

    static {
        products = new ArrayList<>();

        products.add(new Product(1, "Bim Bim", 7000, "Sieu ngon", "OISHI"));
        products.add(new Product(2, "Nuoc tang luc", 15000, "Buzz dame", "RED-BULL"));
        products.add(new Product(3, "Mi an lien", 17000, "Xuc xich di kem", "OMACHI"));
        products.add(new Product(4, "Bo kho", 25000, "Dai ngon", "NA"));
    }

    @Override
    public List<Product> findALlProduct() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.add(id,product);
    }
}
