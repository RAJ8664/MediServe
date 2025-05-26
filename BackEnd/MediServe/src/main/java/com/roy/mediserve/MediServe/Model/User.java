package com.roy.mediserve.MediServe.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private String userImageUrl;
    private String userAddress;
    private String userEmail;

    public User() {}
    public User(String userId, String userName, String userPassword, String userImageUrl, String userAddress, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userImageUrl = userImageUrl;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
    }

    /* Getters  and Setters */
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public String getUserImageUrl() { return userImageUrl; }
    public void setUserImageUrl(String userImageUrl) { this.userImageUrl = userImageUrl; }
    public String getUserAddress() { return userAddress; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
                + ", userImageUrl=" + userImageUrl + ", userAddress=" + userAddress + ", userEmail=" + userEmail
                + "]";
    }
}
