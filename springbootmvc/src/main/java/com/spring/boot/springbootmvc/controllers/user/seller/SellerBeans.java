package com.spring.boot.springbootmvc.controllers.user.seller;

public class SellerBeans {
    private String userId;
    private String userPass;
    private String sellerType;
    private Integer sellerSecurity;
    private Integer isDeleted;
    private String createdAt;
    private String deletedAt;
    private String lastModifiedAt;
    private String userName;
    private Integer age;
    private String emailId;
    private String phone;
    private String checkSellerType;
    private Integer checkPrivalage;
    private String password2;
    private String deleteBy;
    private String updateBy;
    private String gender;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public String getSellerType() {
        return sellerType;
    }
    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }
    public Integer getSellerSecurity() {
        return sellerSecurity;
    }
    public void setSellerSecurity(Integer sellerSecurity) {
        this.sellerSecurity = sellerSecurity;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCheckSellerType() {
        return checkSellerType;
    }
    public void setCheckSellerType(String checkSellerType) {
        this.checkSellerType = checkSellerType;
    }
    public Integer getCheckPrivalage() {
        return checkPrivalage;
    }
    public void setCheckPrivalage(Integer checkPrivalage) {
        this.checkPrivalage = checkPrivalage;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "SellerBeans [userId=" + userId + ", userPass=" + userPass + ", sellerType=" + sellerType
                + ", sellerSecurity=" + sellerSecurity + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt
                + ", deletedAt=" + deletedAt + ", lastModifiedAt=" + lastModifiedAt + ", userName=" + userName
                + ", age=" + age + ", emailId=" + emailId + ", phone=" + phone + ", checkSellerType=" + checkSellerType
                + ", checkPrivalage=" + checkPrivalage + ", password2=" + password2 + ", deleteBy=" + deleteBy
                + ", updateBy=" + updateBy + ", gender=" + gender + "]";
    }

}
