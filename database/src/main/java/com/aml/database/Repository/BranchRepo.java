package com.aml.database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aml.database.Entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
    List<Branch> findAll();

}
