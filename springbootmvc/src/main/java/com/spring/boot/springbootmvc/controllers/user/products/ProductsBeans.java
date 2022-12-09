package com.spring.boot.springbootmvc.controllers.user.products;

import java.sql.Blob;

public class ProductsBeans {
    private String productName;
    private Integer quantity;
    private String productId;
    private String sellerId;
    private String productType;
    private Integer isDeleted = 0;
    private String createdAt;
    private String deletedAt;
    private String lastModifiedAt;
    private String deleteBy;
    private String updateBy;
    private Integer price;
    private String productImgId;

    

    public ProductsBeans() {
    }

    /**
     * @return String return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return Integer return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return String return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return String return the sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId the sellerId to set
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * @return String return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return Integer return the isDeleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return String return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return String return the deletedAt
     */
    public String getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt the deletedAt to set
     */
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @return String return the lastModifiedAt
     */
    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    /**
     * @param lastModifiedAt the lastModifiedAt to set
     */
    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    /**
     * @return String return the deleteBy
     */
    public String getDeleteBy() {
        return deleteBy;
    }

    /**
     * @param deleteBy the deleteBy to set
     */
    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    /**
     * @return String return the updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy the updateBy to set
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(String productImgId) {
        this.productImgId = productImgId;
    }

    @Override
    public String toString() {
        return "ProductsBeans [productName=" + productName + ", quantity=" + quantity + ", productId=" + productId
                + ", sellerId=" + sellerId + ", productType=" + productType + ", isDeleted=" + isDeleted
                + ", createdAt=" + createdAt + ", deletedAt=" + deletedAt + ", lastModifiedAt=" + lastModifiedAt
                + ", deleteBy=" + deleteBy + ", updateBy=" + updateBy + ", price=" + price + ", productImgId="
                + productImgId + "]";
    }





    

}
