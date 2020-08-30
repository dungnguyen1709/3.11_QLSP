package com.c0520k1.service;

import com.c0520k1.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

  private  static Map<Integer,Product> products;

    static {
        products = new HashMap<>();

        products.put(1,new Product(1, "Bim Bim", 7000, "Sieu ngon", "OISHI"));
        products.put(2,new Product(2, "Nuoc tang luc", 15000, "Buzz dame", "RED-BULL"));
        products.put(3,new Product(3, "Mi an lien", 17000, "Xuc xich di kem", "OMACHI"));
        products.put(4,new Product(4, "Bo kho", 25000, "Dai ngon", "NA"));
    }

    @Override
    public List<Product> findALlProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }
}
