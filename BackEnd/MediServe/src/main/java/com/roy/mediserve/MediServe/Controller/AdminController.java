package com.roy.mediserve.MediServe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roy.mediserve.MediServe.Model.Admin;
import com.roy.mediserve.MediServe.Repository.AdminRepository;

@RestController
public class AdminController {

    @Autowired
    private AdminRepository adminRepository; 

    /* Get all the Admins */ 
    @GetMapping("/admin")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return ResponseEntity.ok(admins);
    }

    /* Get Admin by ID */
    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }

    /* Get Admin By adminEmail */
    @GetMapping("/admin/email/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        Admin admin = adminRepository.findByAdminEmail(email);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }
    
    /* Add an admin */
    @PostMapping("/admin")
    public ResponseEntity<Admin> addAdmin(Admin admin) {
        Admin savedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    /* Delete an admin based on adminId */
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        if (!adminRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        adminRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
   
    /* Delete an admin based on adminEmail */
    @DeleteMapping("/admin/email/{email}")
    public ResponseEntity<Void> deleteAdminByEmail(@PathVariable String email) {
        Admin admin = adminRepository.findByAdminEmail(email);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        adminRepository.delete(admin);
        return ResponseEntity.noContent().build();
    }
   
    /*Update adminImageUrl basedOn adminId */
    @PostMapping("/admin/{id}/image")
    public ResponseEntity<Admin> updateAdminImage(@PathVariable String id, String imageUrl) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        admin.setAdminImageUrl(imageUrl);
        Admin updatedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }
   
    /* Update adminName based on adminId */
    @PostMapping("/admin/{id}/name")
    public ResponseEntity<Admin> updateAdminName(@PathVariable String id, String name) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        admin.setAdminName(name);
        Admin updatedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    /* Update adminPassword based on adminId */
    @PostMapping("/admin/{id}/password")
    public ResponseEntity<Admin> updateAdminPassword(@PathVariable String id, String password) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        admin.setAdminPassword(password);
        Admin updatedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }
}
