package com.coforge.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.pms.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findByPname(String pname);

    int deleteByPname(String pname);

    List<Product> findByQuantity(Integer quantity);

    List<Product> findByPrice(Double price);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("select p.pid from Product p")
    List<Long> getPidsList();

    @Query("select count(p), sum(p.price) from Product p")
    String getInfo();

    List<Product> findBySupplierId(Long supplierId);

}