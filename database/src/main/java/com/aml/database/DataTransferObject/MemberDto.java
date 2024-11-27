package com.aml.database.DataTransferObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class MemberDto extends UserDto{
   
    private Boolean isVerified;

    public MemberDto(int id, String username, String email, String password, String role, String city, Boolean isVerified) {
        super(id, username, email, password);  // Call the constructor of UserDto
        this.isVerified = isVerified;
    }
   
}


