package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;
    private Environment environment;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, Environment environment) {
        this.productRepo = productRepo;
        this.environment = environment;
    }

    @Override
    public boolean saveProduct(Product product) {
        productRepo.save(product);
        return true;
    }

    @Override
    public boolean updateProduct(int productId, Product product) {

        if (!productRepo.existsById(productId)) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        product.setPid(productId);
        productRepo.save(product);

        return true;
    }

    @Override
    public boolean deleteProductById(int productId) {

        if (!productRepo.existsById(productId)) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        productRepo.deleteById(productId);
        return true;
    }

    @Override
    public Optional<Product> findByPid(int productId) {

        if (!productRepo.existsById(productId)) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        return productRepo.findById(productId);
    }

    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public List<Product> findByPname(String pname) {

        List<Product> products = productRepo.findByPname(pname);

        if (products.isEmpty()) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        return products;
    }

    @Override
    @Transactional
    public boolean deleteByPname(String pname) {

        int count = productRepo.deleteByPname(pname);

        if (count == 0) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        return true;
    }

    @Override
    public List<Product> findByQuantity(int quantity) {

        List<Product> products = productRepo.findByQuantity(quantity);

        if (products.isEmpty()) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        return products;
    }

    @Override
    public List<Product> findByPrice(double price) {

        List<Product> products = productRepo.findByPrice(price);

        if (products.isEmpty()) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        return products;
    }

    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {

        List<Product> products = productRepo.findByPriceBetween(minPrice, maxPrice);

        if (products.isEmpty()) {
            throw new ProductNotFoundException(
                    environment.getProperty("pms.invalid.product-notfound"));
        }

        return products;
    }

    @Override
    public List<Integer> getPidsList() {
        return productRepo.getPidsList();
    }

    @Override
    public String getInfo() {
        return productRepo.getInfo();
    }
}