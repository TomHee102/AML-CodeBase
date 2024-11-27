package com.aml.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aml.database.Entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
