package com.roy.mediserve.MediServe.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.roy.mediserve.MediServe.Model.Medicine;
import com.roy.mediserve.MediServe.Repository.MedicineRepository;
import com.roy.mediserve.MediServe.Services.MedicineService;

@RestController
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineService medicineService;

    /* Get all Medicines */
    @RequestMapping(method = RequestMethod.GET, path = "/medicine")
    public ResponseEntity<List<Medicine>> getAllMedicine() {
        List<Medicine> medicines = medicineRepository.findAll();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    /* Get a single Medicine by medicineId */
    @RequestMapping(method = RequestMethod.GET, path = "/medicine/{medicineId}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable String medicineId) {
        Medicine medicine = medicineRepository.findById(medicineId).orElse(null);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Add a Medicine */
    @RequestMapping(method = RequestMethod.POST, path = "/medicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        Medicine savedMedicine = medicineRepository.save(medicine);
        return new ResponseEntity<>(savedMedicine, HttpStatus.OK);
    }

    /* Delete a Medicine by medicineId */
    @RequestMapping(method = RequestMethod.DELETE, path = "/medicine/{medicineId}")
    public ResponseEntity<Medicine> deleteMedicineById(@PathVariable String medicineId) {
        Medicine medicine = medicineRepository.findById(medicineId).orElse(null);
        if (medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicineRepository.delete(medicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Update medicineName by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineName/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineNameById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineName(medicine.getMedicineName());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicineDescription by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineDescription/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineDescriptionById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineDescription(medicine.getMedicineDescription());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicinePrice by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicinePrice/{medicineId}")
    public ResponseEntity<Medicine> updateMedicinePriceById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicinePrice(medicine.getMedicinePrice());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicineStock by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineStock/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineStockById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineStock(medicine.getMedicineStock());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicineRating by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineRating/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineRatingById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineRating(medicine.getMedicineRating());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicineQuantity by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineQuantity/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineQuantityById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineQuantity(medicine.getMedicineQuantity());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicineManufacturerName by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineManufacturerName/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineManufacturerNameById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineManufacturerName(medicine.getMedicineManufacturerName());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update expiryDate by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/expiryDate/{medicineId}")
    public ResponseEntity<Medicine> updateExpiryDateById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setExpiryDate(medicine.getExpiryDate());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update category by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/category/{medicineId}")
    public ResponseEntity<Medicine> updateCategoryById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setCategory(medicine.getCategory());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update batchNumber by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/batchNumber/{medicineId}")
    public ResponseEntity<Medicine> updateBatchNumberById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setBatchNumber(medicine.getBatchNumber());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update medicineTags by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineTags/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineTagsById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setMedicineTags(medicine.getMedicineTags());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* Update usageInstruction by medicineId */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/usageInstruction/{medicineId}")
    public ResponseEntity<Medicine> updateUsageInstructionById(@PathVariable String medicineId, @RequestBody Medicine medicine) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.setUsageInstruction(medicine.getUsageInstruction());
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    /* To Remove medicineImageUrl based on medicineId and index of imageUrl */
    @RequestMapping(method = RequestMethod.PUT, path = "/medicine/medicineImageUrl/{medicineId}/{index}")
    public ResponseEntity<Medicine> removeMedicineImageUrlByIdAndIndex(@PathVariable String medicineId, @PathVariable int index) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null || current_medicine.getMedicineImageUrl().size() <= index) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.getMedicineImageUrl().remove(index);
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(current_medicine, HttpStatus.OK);
    }

    /* Update medicineImageUrl by medicineId (add a new imageUrl to the list) */
    @RequestMapping(method = RequestMethod.POST, path = "/medicine/medicineImageUrl/{medicineId}")
    public ResponseEntity<Medicine> updateMedicineImageUrlById(@PathVariable String medicineId, @RequestParam String imageUrl) {
        Medicine current_medicine = medicineRepository.findById(medicineId).orElse(null);
        if (current_medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current_medicine.getMedicineImageUrl().add(imageUrl);
        medicineRepository.save(current_medicine);
        return new ResponseEntity<>(current_medicine, HttpStatus.OK);
    }

    /* Method Implementation for uploading medicine data using csv file --> multiple data at the same time. */
    @PostMapping(value = "/medicine/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadMedicineData(@RequestPart("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(medicineService.uploadMedicineData(file));
    }
}
