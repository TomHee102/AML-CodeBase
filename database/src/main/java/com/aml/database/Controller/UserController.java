package com.aml.database.Controller;

import com.aml.database.DataTransferObject.LoginDto;
import com.aml.database.DataTransferObject.UserProfileDto;
import com.aml.database.DataTransferObject.UserRegistrationDto;
import com.aml.database.Entity.User;
import com.aml.database.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        userService.registerUser(registrationDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered successfully. Please check your email for verification.");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
        userService.verifyEmail(token);
        return ResponseEntity.ok("Email verified successfully. You can now log in.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto) {
        User user = userService.login(loginDto);
        // In a real application, you would generate and return a JWT token here
        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable Long userId) {
        UserProfileDto userProfile = userService.getUserProfile(userId);
        return ResponseEntity.ok(userProfile);
    }

    @PutMapping("/profile/{userId}")
    public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable Long userId,
            @Valid @RequestBody UserProfileDto userProfileDto) {
        UserProfileDto updatedProfile = userService.updateUserProfile(userId, userProfileDto);
        return ResponseEntity.ok(updatedProfile);
    }
}
