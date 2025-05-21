package com.roy.mediserve.MediServe.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seller")
public class Seller {
    @Id
    private String sellerId;
    private String sellerName;
    private String sellerEmail;
    private String sellerPassword;
    private String sellerImageUrl;

    public Seller() {}
    public Seller(String sellerId, String sellerEmail, String sellerName, String sellerPassword, String sellerImageUrl) {
        this.sellerId = sellerId;
        this.sellerEmail = sellerEmail;
        this.sellerName = sellerName;
        this.sellerPassword = sellerPassword;
        this.sellerImageUrl = sellerImageUrl;
    }

    /* Getters and setters */
    public String getSellerId() { return sellerId; }
    public void setSellerId(String sellerId) { this.sellerId = sellerId; }
    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }
    public String getSellerPassword() { return sellerPassword; }
    public void setSellerPassword(String sellerPassword) { this.sellerPassword = sellerPassword; }
    public String getSellerImageUrl() { return sellerImageUrl; }
    public void setSellerImageUrl(String sellerImageUrl) { this.sellerImageUrl = sellerImageUrl; }
    public String getSellerEmail() { return sellerEmail; }
    public void setSellerEmail(String sellerEmail) { this.sellerEmail = sellerEmail; }
    
    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", sellerPassword='" + sellerPassword + '\'' +
                ", sellerImageUrl='" + sellerImageUrl + '\'' +
                '}';
    }

}
