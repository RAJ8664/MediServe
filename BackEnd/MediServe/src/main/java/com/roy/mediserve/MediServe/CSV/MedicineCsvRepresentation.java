package com.roy.mediserve.MediServe.CSV;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineCsvRepresentation {
   
    @CsvBindByName(column = "medicineName")
    private String medicineName;

    @CsvBindByName(column = "medicineDescription")
    private String medicineDescription;
   
    @CsvBindByName(column = "medicineImageUrl")
    private String medicineImageUrl;
   
    @CsvBindByName(column = "medicinePrice")
    private String medicinePrice;
   
    @CsvBindByName(column = "medicineStock")
    private String medicineStock;
   
    @CsvBindByName(column = "medicineRating")
    private String medicineRating;
   
    @CsvBindByName(column = "medicineQuantity")
    private String medicineQuantity;
   
    @CsvBindByName(column = "medicineManufacturerName")
    private String medicineManufacturerName;
   
    @CsvBindByName(column = "expiryDate")
    private String expiryDate;
   
    @CsvBindByName(column = "category")
    private String category;
   
    @CsvBindByName(column = "batchNumber")
    private String batchNumber;
   
    @CsvBindByName(column = "medicineTags")
    private String medicineTags;
   
    @CsvBindByName(column = "usageInstruction")
    private String usageInstruction;
 }
