package com.aml.database.Service.Impl;

import com.aml.database.DataTransferObject.LoginDto;
import com.aml.database.DataTransferObject.UserProfileDto;
import com.aml.database.DataTransferObject.UserRegistrationDto;
import com.aml.database.Entity.User;
import com.aml.database.Exception.EmailAlreadyExistsException;
import com.aml.database.Exception.InvalidCredentialsException;
import com.aml.database.Exception.UserNotFoundException;
import com.aml.database.Mapper.UserMapper;
import com.aml.database.Repository.UserRepository;
import com.aml.database.Service.EmailService;
import com.aml.database.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Remove the @Autowired UserMapper line as we're now using static methods

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Override
    @Transactional
    public User registerUser(UserRegistrationDto registrationDto) {
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = UserMapper.mapToUser(registrationDto);
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setVerificationToken(UUID.randomUUID().toString());

        User savedUser = userRepository.save(user);

        emailService.sendVerificationEmail(savedUser.getEmail(), savedUser.getVerificationToken());

        return savedUser;
    }

    @Override
    @Transactional
    public void verifyEmail(String token) {
        User user = userRepository.findByVerificationToken(token)
                .orElseThrow(() -> new UserNotFoundException("Invalid verification token"));

        user.setEmailVerified(true);
        user.setVerificationToken(null);
        userRepository.save(user);
    }

    @Override
    public User login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        if (!user.isEmailVerified()) {
            throw new InvalidCredentialsException("Email not verified");
        }

        return user;
    }

    @Override
    public UserProfileDto getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return UserMapper.mapToUserProfileDto(user);
    }

    @Override
    @Transactional
    public UserProfileDto updateUserProfile(Long userId, UserProfileDto userProfileDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!user.getEmail().equals(userProfileDto.getEmail())
                && userRepository.existsByEmail(userProfileDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User updatedUser = UserMapper.updateUserFromDto(user, userProfileDto);
        User savedUser = userRepository.save(updatedUser);
        return UserMapper.mapToUserProfileDto(savedUser);
    }
}
