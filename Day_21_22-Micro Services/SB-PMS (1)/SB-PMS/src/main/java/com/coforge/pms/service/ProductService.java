package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.dto.ProductDTO;
import com.coforge.pms.model.Product;

public interface ProductService {

    boolean saveProduct(Product product);

    boolean updateProduct(Long productId, Product product);

    boolean deleteProductById(Long productId);

    Optional<Product> findByPid(Long productId);

    List<Product> findAllProducts();

    List<Product> findByPname(String pname);

    boolean deleteByPname(String pname);

    List<Product> findByQuantity(Integer quantity);

    List<Product> findByPrice(Double price);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Long> getPidsList();

    String getInfo();

    List<Product> findBySupplierId(Long supplierId);

    ProductDTO getProductWithSupplier(Long productId);

}