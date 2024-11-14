package com.aml.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aml.database.Entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
}
