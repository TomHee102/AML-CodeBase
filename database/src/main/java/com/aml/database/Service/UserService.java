package com.aml.database.Service;

import com.aml.database.DataTransferObject.LoginDto;
import com.aml.database.DataTransferObject.UserProfileDto;
import com.aml.database.DataTransferObject.UserRegistrationDto;
import com.aml.database.Entity.User;

public interface UserService {
    User registerUser(UserRegistrationDto registrationDto);
    void verifyEmail(String token);
    User login(LoginDto loginDto);
    UserProfileDto getUserProfile(Long userId);
    UserProfileDto updateUserProfile(Long userId, UserProfileDto userProfileDto);
}

