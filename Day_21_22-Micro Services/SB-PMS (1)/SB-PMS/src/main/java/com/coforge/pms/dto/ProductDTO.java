package com.coforge.pms.dto;

public class ProductDTO {

    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private SupplierDTO supplier;

    public ProductDTO() {
        super();
    }

    public ProductDTO(Long productId, String productName, Double price,
                      Integer quantity, SupplierDTO supplier) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "ProductDTO [productId=" + productId +
                ", productName=" + productName +
                ", price=" + price +
                ", quantity=" + quantity +
                ", supplier=" + supplier + "]";
    }
}