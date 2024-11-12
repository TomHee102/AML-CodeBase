package com.aml.database.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.database.Dto.MediaDto;
import com.aml.database.Service.MediaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/media")
public class MediaController {

    private MediaService mediaService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<MediaDto> createMedia(@RequestBody MediaDto mediaDto) {
        MediaDto savedMedia = mediaService.createMedia(mediaDto);
        return new ResponseEntity<>(savedMedia, HttpStatus.CREATED);
    }
}
