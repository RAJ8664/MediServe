package com.roy.mediserve.MediServe.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.roy.mediserve.MediServe.Model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	Admin findByAdminEmail(String adminEmail);    
}
