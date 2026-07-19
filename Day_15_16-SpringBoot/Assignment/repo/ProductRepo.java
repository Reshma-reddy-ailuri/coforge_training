package com.coforge.pms.repo;
// repository == DAO layer

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.pms.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer>{

    public List<Product> findByPname(String pname);

    public int deleteByPname(String pname);

    public List<Product> findByQuantity(int quantity);

    public List<Product> findByPrice(double price);

    public List<Product> findByPriceBetween(double minPrice,double maxPrice);

    @Query("select pid from Product")
    public List<Integer> getPids();

    @Query("select count(p), sum(p.price) from Product p")
    public Object[] getInfo();
}
