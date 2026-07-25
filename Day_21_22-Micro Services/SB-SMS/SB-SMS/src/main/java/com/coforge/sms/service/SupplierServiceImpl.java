package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.sms.exception.SupplierNotFoundException;
import com.coforge.sms.model.Supplier;
import com.coforge.sms.repo.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepo repo;
    private Environment environment;

    @Autowired
    public SupplierServiceImpl(SupplierRepo repo, Environment environment) {
        this.repo = repo;
        this.environment = environment;
    }

    @Override
    public boolean saveSupplier(Supplier supplier) {

        repo.save(supplier);
        return true;
    }

    @Override
    public boolean updateSupplier(Long supplierId, Supplier supplier) {

        if (!repo.existsById(supplierId)) {
            throw new SupplierNotFoundException(
                    environment.getProperty("sms.invalid.supplier-notfound"));
        }

        supplier.setSupplierId(supplierId);
        repo.save(supplier);

        return true;
    }

    @Override
    public boolean deleteBysupplierId(Long supplierId) {

        if (!repo.existsById(supplierId)) {
            throw new SupplierNotFoundException(
                    environment.getProperty("sms.invalid.supplier-notfound"));
        }

        repo.deleteById(supplierId);

        return true;
    }
    @Override
    public Optional<Supplier> findBysupplierId(Long supplierId) {

        System.out.println("Searching Supplier Id : " + supplierId);
        System.out.println("Exists : " + repo.existsById(supplierId));

        if (!repo.existsById(supplierId)) {
            throw new SupplierNotFoundException(
                    environment.getProperty("sms.invalid.supplier-notfound"));
        }

        return repo.findById(supplierId);
    }
    
    @Override
    public List<Supplier> getAllSuppliers() {

        List<Supplier> suppliers = repo.findAll();

        if (suppliers.isEmpty()) {
            throw new SupplierNotFoundException(
                    environment.getProperty("sms.invalid.supplier-notfound"));
        }

        return suppliers;
    }

    @Override
    public List<Supplier> findBysupplierName(String supplierName) {

        List<Supplier> suppliers = repo.findBySupplierName(supplierName);

        if (suppliers.isEmpty()) {
            throw new SupplierNotFoundException(
                    environment.getProperty("sms.invalid.supplier-notfound"));
        }

        return suppliers;
    }

    @Override
    public boolean deleteBysupplierName(String supplierName) {

        int count = repo.deleteBySupplierName(supplierName);

        if (count == 0) {
            throw new SupplierNotFoundException(
                    environment.getProperty("sms.invalid.supplier-notfound"));
        }

        return true;
    }

    @Override
    public List<Long> getsupplierIdsList() {

        return repo.getSupplierIdsList();
    }

}