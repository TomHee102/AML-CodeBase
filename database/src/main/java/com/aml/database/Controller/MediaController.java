package com.aml.database.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.database.Entity.Media;
import com.aml.database.Repository.MediaRepo;

@CrossOrigin("*")
@RestController
public class MediaController {

    @Autowired
    private MediaRepo mediaService;

    @GetMapping("/media")
    public List<Media> getMedia() {
        return this.mediaService.getMediaData();
    }
}
