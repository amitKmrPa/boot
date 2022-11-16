package com.spring.boot.springbootmvc.controllers.user.admin;

public class AdminBeans {
    private String userId;
    private String userPass;
    private String adminType;
    private Integer adminSecurity;
    private Integer isDeleted;
    private String createdAt;
    private String deletedAt;
    private String lastModifiedAt;
    private String userName;
    private Integer age;
    private String emailId;
    private String phone;
    private String checkAdminType;
    private Integer checkPrivalage;
    private String password2;
    private String deleteBy;
    private String updateBy;

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
     * @return String return the adminType
     */
    public String getAdminType() {
        return adminType;
    }

    /**
     * @param adminType the adminType to set
     */
    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    /**
     * @return Integer return the adminSecurity
     */
    public Integer getAdminSecurity() {
        return adminSecurity;
    }

    /**
     * @param adminSecurity the adminSecurity to set
     */
    public void setAdminSecurity(Integer adminSecurity) {
        this.adminSecurity = adminSecurity;
    }

    /**
     * @return String return the isDeleted
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
     * @return String return the checkAdminType
     */
    public String getCheckAdminType() {
        return checkAdminType;
    }

    /**
     * @param checkAdminType the checkAdminType to set
     */
    public void setCheckAdminType(String checkAdminType) {
        this.checkAdminType = checkAdminType;
    }

    /**
     * @return Integer return the checkPrivalage
     */
    public Integer getCheckPrivalage() {
        return checkPrivalage;
    }

    /**
     * @param checkPrivalage the checkPrivalage to set
     */
    public void setCheckPrivalage(Integer checkPrivalage) {
        this.checkPrivalage = checkPrivalage;
    }

    @Override
    public String toString() {
        return "AdminBeans [userId=" + userId + ", userPass=" + userPass + ", adminType=" + adminType
                + ", adminSecurity=" + adminSecurity + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt
                + ", deletedAt=" + deletedAt + ", lastModifiedAt=" + lastModifiedAt + ", userName=" + userName
                + ", age=" + age + ", emailId=" + emailId + ", phone=" + phone + ", checkAdminType=" + checkAdminType
                + ", checkPrivalage=" + checkPrivalage + "]";
    }

   


    /**
     * @return String return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
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
