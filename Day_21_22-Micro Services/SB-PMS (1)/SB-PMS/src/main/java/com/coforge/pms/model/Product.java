package com.coforge.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tbl_products")
public class Product {

    @Id
    @Column(name = "pid")
    @NotNull
    private Long pid;

    @Column(name = "pname", length = 100)
    @NotBlank
    private String pname;

    @Column(name = "price")
    @Positive
    private Double price;

    @Column(name = "quantity")
    @Positive
    private Integer quantity;

    @Column(name = "supplierId")
    @NotNull
    private Long supplierId;

    public Product() {
    }

    public Product(Long pid, String pname, Double price, Integer quantity, Long supplierId) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid +
                ", pname=" + pname +
                ", price=" + price +
                ", quantity=" + quantity +
                ", supplierId=" + supplierId + "]";
    }
}