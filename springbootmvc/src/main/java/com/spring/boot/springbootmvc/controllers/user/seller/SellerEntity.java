package com.spring.boot.springbootmvc.controllers.user.seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller_table")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "user_Id")
    private String userId;

    @Column(name = "user_Pass")
    private String userPass;

    @Column(name = "seller_type")
    private String sellerType;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "seller_security")
    private Integer sellerSecurity;

    
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

    @Column(name = "gender")
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getSellerSecurity() {
        return sellerSecurity;
    }

    public void setSellerSecurity(Integer sellerSecurity) {
        this.sellerSecurity = sellerSecurity;
    }

    @Override
    public String toString() {
        return "SellerEntity [id=" + id + ", userName=" + userName + ", age=" + age + ", userId=" + userId
                + ", userPass=" + userPass + ", sellerType=" + sellerType + ", emailId=" + emailId + ", phone=" + phone
                + ", sellerSecurity=" + sellerSecurity + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt
                + ", deletedAt=" + deletedAt + ", lastModifiedAt=" + lastModifiedAt + ", deleteBy=" + deleteBy
                + ", updateBy=" + updateBy + ", gender=" + gender + "]";
    }

  
    
}
