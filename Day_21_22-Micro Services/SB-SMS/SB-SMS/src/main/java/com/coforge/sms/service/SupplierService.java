package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.sms.model.Supplier;

public interface SupplierService {

    boolean saveSupplier(Supplier supplier);

    boolean updateSupplier(Long supplierId, Supplier supplier);

    boolean deleteBysupplierId(Long supplierId);

    Optional<Supplier> findBysupplierId(Long supplierId);

    List<Supplier> getAllSuppliers();

    List<Supplier> findBysupplierName(String supplierName);

    boolean deleteBysupplierName(String supplierName);

    List<Long> getsupplierIdsList();

}