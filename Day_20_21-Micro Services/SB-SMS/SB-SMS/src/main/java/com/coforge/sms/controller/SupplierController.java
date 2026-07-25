package com.coforge.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.sms.model.Supplier;
import com.coforge.sms.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sms")
public class SupplierController {

    private SupplierService service;
    private Environment environment;

    @Autowired
    public SupplierController(SupplierService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @PostMapping("/suppliers")
    public ResponseEntity<String> saveSupplier(@Valid @RequestBody Supplier supplier) {

        service.saveSupplier(supplier);

        return new ResponseEntity<>(
                environment.getProperty("sms.save.success"),
                HttpStatus.CREATED);
    }

    @PutMapping("/suppliers/{supplierId}")
    public ResponseEntity<String> updateSupplier(
            @PathVariable Long supplierId,
            @Valid @RequestBody Supplier supplier) {

        service.updateSupplier(supplierId, supplier);

        return new ResponseEntity<>(
                environment.getProperty("sms.update.success"),
                HttpStatus.OK);
    }

    @DeleteMapping("/suppliers/{supplierId}")
    public ResponseEntity<String> deleteBySupplierId(
            @PathVariable Long supplierId) {

        service.deleteBysupplierId(supplierId);

        return new ResponseEntity<>(
                environment.getProperty("sms.delete.success"),
                HttpStatus.OK);
    }

    @GetMapping("/suppliers/{supplierId}")
    public ResponseEntity<Supplier> findBySupplierId(
            @PathVariable Long supplierId) {

        Optional<Supplier> supplier = service.findBysupplierId(supplierId);

        return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {

        return new ResponseEntity<>(
                service.getAllSuppliers(),
                HttpStatus.OK);
    }

    @GetMapping("/suppliers/supplierName/{supplierName}")
    public ResponseEntity<List<Supplier>> findBySupplierName(
            @PathVariable String supplierName) {

        return new ResponseEntity<>(
                service.findBysupplierName(supplierName),
                HttpStatus.OK);
    }

    @DeleteMapping("/suppliers/supplierName/{supplierName}")
    public ResponseEntity<String> deleteBySupplierName(
            @PathVariable String supplierName) {

        service.deleteBysupplierName(supplierName);

        return new ResponseEntity<>(
                environment.getProperty("sms.delete.success"),
                HttpStatus.OK);
    }

    @GetMapping("/suppliers/supplierIds")
    public ResponseEntity<List<Long>> getsupplierIdsList() {

        return new ResponseEntity<>(
                service.getsupplierIdsList(),
                HttpStatus.OK);
    }

}