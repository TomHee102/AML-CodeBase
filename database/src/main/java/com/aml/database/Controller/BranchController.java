package com.aml.database.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.database.Entity.Branch;
import com.aml.database.Service.BranchService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor  
@RequestMapping("/api/branch")
@CrossOrigin(origins = "*") 
public class BranchController { ////realtime project
 
    private BranchService branchservice;

   @GetMapping
    public List<Branch> getAllBranches() {
        return branchservice.getAllBranches();
    }
}
