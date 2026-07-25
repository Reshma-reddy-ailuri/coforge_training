package com.coforge.sms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.coforge.sms.model.Supplier;

import jakarta.transaction.Transactional;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findBySupplierId(Long supplierId);

    List<Supplier> findBySupplierName(String supplierName);

    @Transactional
    @Modifying
    int deleteBySupplierName(String supplierName);

    @Query("select s.supplierId from Supplier s")
    List<Long> getSupplierIdsList();
}