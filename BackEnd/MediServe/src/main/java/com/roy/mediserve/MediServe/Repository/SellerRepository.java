package com.roy.mediserve.MediServe.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.roy.mediserve.MediServe.Model.Seller;

@Repository
public interface SellerRepository extends MongoRepository<Seller, String> {
    
}
