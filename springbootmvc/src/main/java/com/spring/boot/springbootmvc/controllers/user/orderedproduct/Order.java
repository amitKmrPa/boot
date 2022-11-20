package com.spring.boot.springbootmvc.controllers.user.orderedproduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_Id")
    private String productId;

    @Column(name = "seller_Id")
    private String sellerId;
    
    @Column(name = "is_deleted")
    private Integer isDeleted = 0;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "deleted_at")
    private String deletedAt;

    @Column(name = "last_modified_at")
    private String lastModifiedAt;

    @Column(name = "deleted_by")
    private String deleteBy;

    @Column(name = "updated_by")
    private String updateBy;

    

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

   


    /**
     * @return Integer return the orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }



    


    /**
     * @return String return the productId
     */
    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", quantity=" + quantity + ", orderId=" + orderId + ", productId=" + productId
                + ", sellerId=" + sellerId + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + ", deletedAt="
                + deletedAt + ", lastModifiedAt=" + lastModifiedAt + ", deleteBy=" + deleteBy + ", updateBy=" + updateBy
                + "]";
    }
    

    

}
