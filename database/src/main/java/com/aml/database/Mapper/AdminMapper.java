package com.aml.database.Mapper;

import com.aml.database.DataTransferObject.AdminDto;
import com.aml.database.Entity.Admin;
import com.aml.database.Entity.Branch;

public class AdminMapper {

    public static AdminDto mapToAdminDto(Admin admin) {
        if (admin == null) {
            return null;
        }
        return new AdminDto(
                admin.getId(),
                admin.getUsername(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getCity(),
                admin.getRole(),
                admin.getBranch() != null && !admin.getBranch().isEmpty() ? admin.getBranch().get(0).getId() : null 
        );
    }

    public static Admin mapToAdmin(AdminDto adminDto, Branch branch) {
        if (adminDto == null) {
            return null;
        }
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setUsername(adminDto.getUsername());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setCity(adminDto.getCity());
        admin.setRole(adminDto.getRole());
        
        if (branch != null) {
            admin.getBranch().add(branch); 
        }
        return admin;
    }
}
