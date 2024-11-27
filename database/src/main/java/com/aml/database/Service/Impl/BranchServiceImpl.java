package com.aml.database.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aml.database.Entity.Branch;
import com.aml.database.Repository.BranchRepo;
import com.aml.database.Service.BranchService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class BranchServiceImpl implements BranchService{
    
    private BranchRepo branchRepository;

    public List<Branch> getAllBranches() {
            return branchRepository.findAll(); 
        }

     }
