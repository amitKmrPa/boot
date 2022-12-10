package com.spring.boot.springbootmvc.controllers.invoice;




public class InvoiceBean {
    private String productId;
    private String invoiceId;
    private String userId;
    private String sellerId;
    private Integer isDeleted;
    private Integer totalPrice ;
    private Integer gst ;
    private String createdAt;
    private String deletedAt;
    private String lastModifiedAt;
    private String deleteBy;
    private String updateBy;
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getSellerId() {
        return sellerId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Integer getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Integer getGst() {
        return gst;
    }
    public void setGst(Integer gst) {
        this.gst = gst;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }
    public String getLastModifiedAt() {
        return lastModifiedAt;
    }
    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
    public String getDeleteBy() {
        return deleteBy;
    }
    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }
    public String getUpdateBy() {
        return updateBy;
    }
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    @Override
    public String toString() {
        return "InvoiceBean [productId=" + productId + ", invoiceId=" + invoiceId + ", userId=" + userId + ", sellerId="
                + sellerId + ", isDeleted=" + isDeleted + ", totalPrice=" + totalPrice + ", gst=" + gst + ", createdAt="
                + createdAt + ", deletedAt=" + deletedAt + ", lastModifiedAt=" + lastModifiedAt + ", deleteBy="
                + deleteBy + ", updateBy=" + updateBy + "]";
    }

    

}
