package com.roy.mediserve.MediServe.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
public class Admin {
    @Id
    private String adminId;
    private String adminName;
    private String adminPassword;
    private String adminImageUrl;

    public Admin() {}
    public Admin(String adminId, String adminName, String adminPassword, String adminImageUrl) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminImageUrl = adminImageUrl;
    }

    /* Getters and Setters */
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public String getAdminPassword() { return adminPassword; }
    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }
    public String getAdminImageUrl() { return adminImageUrl; }
    public void setAdminImageUrl(String adminImageUrl) { this.adminImageUrl = adminImageUrl; }
    
    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + ", adminImageUrl=" + adminImageUrl + "]";
    } 
}
