package com.roy.mediserve.MediServe.Model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicine")
public class Medicine {
    @Id
    private String medicineId;
    private String medicineName;
    private String medicineDescription;
    private List<String> medicineImageUrl;
    private double medicinePrice;
    private Long medicineStock;
    private double medicineRating;
    private List<String> medicineQuantity;
    private String medicineManufacturerName;
    private String expiryDate;
    private List<String> category;
    private String batchNumber;
    private List<String> medicineTags;
    private String usageInstruction;

    public Medicine() {}
    public Medicine(String medicineId, String medicineName, String medicineDescription, List<String> medicineImageUrl,
            double medicinePrice, Long medicineStock, double medicineRating, List<String> medicineQuantity,
            String medicineManufacturerName, String expiryDate, List<String> category, String batchNumber,
            List<String> medicineTags, String usageInstruction) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.medicineImageUrl = medicineImageUrl;
        this.medicinePrice = medicinePrice;
        this.medicineStock = medicineStock;
        this.medicineRating = medicineRating;
        this.medicineQuantity = medicineQuantity;
        this.medicineManufacturerName = medicineManufacturerName;
        this.expiryDate = expiryDate;
        this.category = category;
        this.batchNumber = batchNumber;
        this.medicineTags = medicineTags;
        this.usageInstruction = usageInstruction;
    }

    /* Getters and Setters */
    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public String getMedicineDescription() { return medicineDescription; }
    public void setMedicineDescription(String medicineDescription) { this.medicineDescription = medicineDescription; }
    public List<String> getMedicineImageUrl() { return medicineImageUrl; }
    public void setMedicineImageUrl(List<String> medicineImageUrl) { this.medicineImageUrl = medicineImageUrl; }
    public double getMedicinePrice() { return medicinePrice; }
    public void setMedicinePrice(double medicinePrice) { this.medicinePrice = medicinePrice; }
    public Long getMedicineStock() { return medicineStock; }
    public void setMedicineStock(Long medicineStock) { this.medicineStock = medicineStock; }
    public double getMedicineRating() { return medicineRating; }
    public void setMedicineRating(double medicineRating) { this.medicineRating = medicineRating; }
    public List<String> getMedicineQuantity() { return medicineQuantity; }
    public void setMedicineQuantity(List<String> medicineQuantity) { this.medicineQuantity = medicineQuantity; }
    public String getMedicineManufacturerName() { return medicineManufacturerName; }
    public void setMedicineManufacturerName(String medicineManufacturerName) { this.medicineManufacturerName = medicineManufacturerName; }
    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public List<String> getCategory() { return category; }
    public void setCategory(List<String> category) { this.category = category; }
    public String getBatchNumber() { return batchNumber; }
    public void setBatchNumber(String batchNumber) { this.batchNumber = batchNumber; }
    public List<String> getMedicineTags() { return medicineTags; }
    public void setMedicineTags(List<String> medicineTags) { this.medicineTags = medicineTags; }
    public String getUsageInstruction() { return usageInstruction; }
    public void setUsageInstruction(String usageInstruction) { this.usageInstruction = usageInstruction; }

    @Override
    public String toString() {
        return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineDescription="
                + medicineDescription + ", medicineImageUrl=" + medicineImageUrl + ", medicinePrice=" + medicinePrice
                + ", medicineStock=" + medicineStock + ", medicineRating=" + medicineRating + ", medicineQuantity="
                + medicineQuantity + ", medicineManufacturerName=" + medicineManufacturerName + ", expiryDate="
                + expiryDate + ", category=" + category + ", batchNumber=" + batchNumber + ", medicineTags="
                + medicineTags + ", usageInstruction=" + usageInstruction + "]";
    }
}
