package com.roy.mediserve.MediServe.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.roy.mediserve.MediServe.CSV.MedicineCsvRepresentation;
import com.roy.mediserve.MediServe.Model.Medicine;
import com.roy.mediserve.MediServe.Repository.MedicineRepository;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    /*Below two are the implementation responsible for uploading the medicine data from the csv file */
    public Integer uploadMedicineData(MultipartFile file) throws IOException {
        Set<Medicine> medicines = parseCsv(file);
        medicineRepository.saveAll(medicines);
        return medicines.size();
    }
    private Set<Medicine> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<MedicineCsvRepresentation> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(MedicineCsvRepresentation.class);
            CsvToBean<MedicineCsvRepresentation> csvToBean =
                new CsvToBeanBuilder<MedicineCsvRepresentation>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<MedicineCsvRepresentation> csvLines = csvToBean.parse();
            return csvLines.stream()
                .map(csvline -> Medicine.builder()
                    .medicineName(csvline.getMedicineName())
                    .medicineDescription(csvline.getMedicineDescription())
                    .medicineImageUrl(Arrays.asList(csvline.getMedicineImageUrl().split(",")))
                    .medicinePrice(Double.parseDouble(csvline.getMedicinePrice()))
                    .medicineStock(Long.parseLong(csvline.getMedicineStock()))
                    .medicineRating(Double.parseDouble(csvline.getMedicineRating()))
                    .medicineQuantity(Arrays.asList(csvline.getMedicineQuantity().split(",")))
                    .medicineManufacturerName(csvline.getMedicineManufacturerName())
                    .expiryDate(csvline.getExpiryDate())
                    .category(Arrays.asList(csvline.getCategory().split(",")))
                    .batchNumber(csvline.getBatchNumber())
                    .medicineTags(Arrays.asList(csvline.getMedicineTags().split(",")))
                    .usageInstruction(csvline.getUsageInstruction())
                    .build()
                )
                .collect(Collectors.toSet());
        }
    }
}


