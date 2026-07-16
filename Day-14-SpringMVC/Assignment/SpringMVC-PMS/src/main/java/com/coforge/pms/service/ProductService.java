package com.coforge.pms.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.coforge.pms.model.Product;

@Service
public class ProductService {

    private Map<Integer, Product> PMap = new HashMap<>();

    public boolean createProduct(Product product) {

        if (PMap.containsKey(product.getPid())) {
            return false;
        }

        PMap.put(product.getPid(), product);
        return true;
    }

    public boolean updateProduct(Product product) {

        if (PMap.containsKey(product.getPid())) {
            PMap.put(product.getPid(), product);
            return true;
        }

        return false;
    }

    public boolean deleteProduct(int pid) {

        if (PMap.containsKey(pid)) {
            PMap.remove(pid);
            return true;
        }

        return false;
    }

    public Product findProduct(int pid) {

        return PMap.get(pid);
    }
    
    public Collection<Product> findAllProducts() {

        return PMap.values();
    }

}