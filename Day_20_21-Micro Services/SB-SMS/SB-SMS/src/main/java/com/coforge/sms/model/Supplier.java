package com.coforge.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_supplier")
public class Supplier {

    @Id
    @Column(name = "supplierId")
    @NotNull
    private Long supplierId;

    @Column(name = "supplierName", length = 100)
    @NotBlank
    private String supplierName;

    @Column(name = "city", length = 50)
    @NotBlank
    private String city;

    public Supplier() {
    }

    public Supplier(Long supplierId, String supplierName, String city) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.city = city;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Supplier [supplierId=" + supplierId +
               ", supplierName=" + supplierName +
               ", city=" + city + "]";
    }
}