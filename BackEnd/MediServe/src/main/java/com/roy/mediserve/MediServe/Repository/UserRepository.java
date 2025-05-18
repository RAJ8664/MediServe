package com.roy.mediserve.MediServe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roy.mediserve.MediServe.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
