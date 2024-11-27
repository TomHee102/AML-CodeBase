package com.aml.database.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    public UserDto(String name2, String role2) {
    }
    private int id;
    private String username;
    private String email;
    private String password;

}



