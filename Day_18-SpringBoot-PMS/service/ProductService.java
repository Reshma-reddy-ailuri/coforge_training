package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.model.Product;

public interface ProductService {

    boolean saveProduct(Product product);

    boolean updateProduct(int productId, Product product);

    boolean deleteProductById(int productId);

    Optional<Product> findByPid(int productId);

    List<Product> findAllProducts();

    List<Product> findByPname(String pname);

    boolean deleteByPname(String pname);

    List<Product> findByQuantity(int quantity);

    List<Product> findByPrice(double price);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Integer> getPidsList();

    String getInfo();
}