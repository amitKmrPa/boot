package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b2cuser_table")
public class B2cEntity {
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

    @Column(name = "gender")
    private String gender;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone")
    private String phone;
    
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

    

    @Override
    public String toString() {
        return "B2cEntity [id=" + id + ", userName=" + userName + ", age=" + age + ", userId=" + userId + ", userPass="
                + userPass + ", gender=" + gender + ", emailId=" + emailId + ", phone=" + phone + ", isDeleted="
                + isDeleted + ", createdAt=" + createdAt + ", deletedAt=" + deletedAt + ", lastModifiedAt="
                + lastModifiedAt + ", deleteBy=" + deleteBy + ", updateBy=" + updateBy + "]";
    }

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
     * @return String return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return Integer return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return String return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return String return the userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass the userPass to set
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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

}
