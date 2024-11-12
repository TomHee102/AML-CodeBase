package com.aml.database.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.Service.MediaService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/media")
public class MediaController {

    private MediaService mediaService;

    // Add Media
    @PostMapping
    public ResponseEntity<MediaDto> createMedia(@RequestBody MediaDto mediaDto) {
        MediaDto savedMedia = mediaService.createMedia(mediaDto);
        return new ResponseEntity<>(savedMedia, HttpStatus.CREATED);
    }

    // Get Media by id
    @GetMapping("{id}")
    public ResponseEntity<MediaDto> getMediaById(@PathVariable("id") Integer mediaId) {
        MediaDto mediaDto = mediaService.getMediaById(mediaId);
        return ResponseEntity.ok(mediaDto);
    }

    // Get All Media
    @GetMapping
    public ResponseEntity<List<MediaDto>> getAllMedia() {
        List<MediaDto> media = mediaService.getAllMedia();
        return ResponseEntity.ok(media);
    }
}
