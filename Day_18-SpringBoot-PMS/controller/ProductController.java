package com.coforge.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pms")
public class ProductController {

    private ProductService service;
    private Environment environment;

    @Autowired
    public ProductController(ProductService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @PostMapping("/products")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody Product product) {

        service.saveProduct(product);

        return new ResponseEntity<>(
                environment.getProperty("pms.save.success"),
                HttpStatus.CREATED);
    }

    @PutMapping("/products/{pid}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int pid,
            @Valid @RequestBody Product product) {

        service.updateProduct(pid, product);

        return new ResponseEntity<>(
                environment.getProperty("pms.update.success"),
                HttpStatus.OK);
    }

    @DeleteMapping("/products/{pid}")
    public ResponseEntity<String> deleteByPid(@PathVariable int pid) {

        service.deleteProductById(pid);

        return new ResponseEntity<>(
                environment.getProperty("pms.delete.success"),
                HttpStatus.OK);
    }

    @GetMapping("/products/{pid}")
    public ResponseEntity<Product> findByPid(@PathVariable int pid) {

        Optional<Product> product = service.findByPid(pid);

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {

        return new ResponseEntity<>(
                service.findAllProducts(),
                HttpStatus.OK);
    }

    @GetMapping("/products/name/{pname}")
    public ResponseEntity<List<Product>> findByPname(
            @PathVariable String pname) {

        return new ResponseEntity<>(
                service.findByPname(pname),
                HttpStatus.OK);
    }

    @DeleteMapping("/products/name/{pname}")
    public ResponseEntity<String> deleteByPname(
            @PathVariable String pname) {

        service.deleteByPname(pname);

        return new ResponseEntity<>(
                environment.getProperty("pms.delete.success"),
                HttpStatus.OK);
    }

    @GetMapping("/products/quantity/{quantity}")
    public ResponseEntity<List<Product>> findByQuantity(
            @PathVariable int quantity) {

        return new ResponseEntity<>(
                service.findByQuantity(quantity),
                HttpStatus.OK);
    }

    @GetMapping("/products/price/{price}")
    public ResponseEntity<List<Product>> findByPrice(
            @PathVariable double price) {

        return new ResponseEntity<>(
                service.findByPrice(price),
                HttpStatus.OK);
    }

    @GetMapping("/products/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Product>> findByPriceBetween(
            @PathVariable double minPrice,
            @PathVariable double maxPrice) {

        return new ResponseEntity<>(
                service.findByPriceBetween(minPrice, maxPrice),
                HttpStatus.OK);
    }

    @GetMapping("/products/pids")
    public ResponseEntity<List<Integer>> getPidsList() {

        return new ResponseEntity<>(
                service.getPidsList(),
                HttpStatus.OK);
    }

    @GetMapping("/products/info")
    public ResponseEntity<String> getInfo() {

        return new ResponseEntity<>(
                service.getInfo(),
                HttpStatus.OK);
    }
}