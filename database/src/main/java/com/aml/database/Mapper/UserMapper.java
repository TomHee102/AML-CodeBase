package com.aml.database.Mapper;

import com.aml.database.DataTransferObject.UserProfileDto;
import com.aml.database.DataTransferObject.UserRegistrationDto;
import com.aml.database.Entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserMapper {

    public static UserProfileDto mapToUserProfileDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserProfileDto(
            user.getFirstName(),
            user.getLastName(),
            user.getEmail()
        );
    }

    public static User mapToUser(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDto == null) {
            return null;
        }
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword()); // Note: This should be encoded before saving
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmailVerified(false);
        user.setVerificationToken(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    public static User updateUserFromDto(User user, UserProfileDto userProfileDto) {
        if (user == null || userProfileDto == null) {
            return user;
        }
        user.setFirstName(userProfileDto.getFirstName());
        user.setLastName(userProfileDto.getLastName());
        user.setEmail(userProfileDto.getEmail());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }
}


