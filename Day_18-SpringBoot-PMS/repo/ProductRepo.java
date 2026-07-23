package com.coforge.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.pms.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

	List<Product> findByPname(String pname);

	int deleteByPname(String pname);

	List<Product> findByQuantity(int quantity);

	List<Product> findByPrice(double price);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	@Query("select p.pid from Product p")
	List<Integer> getPidsList();

	@Query("select count(p), sum(p.price) from Product p")
	String getInfo();
}