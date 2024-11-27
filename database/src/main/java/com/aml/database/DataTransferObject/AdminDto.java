package com.aml.database.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private int id;
    private String username;
    private String email;
    private String password; // Ensure this is String
    private String city;
    private String role;
    private Integer branchId; // Added field for branch ID
}
