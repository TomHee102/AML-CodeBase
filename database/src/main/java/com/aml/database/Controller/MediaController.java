package com.aml.database.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.DataTransferObject.TransferRequest;
import com.aml.database.Service.MediaService;
import com.aml.database.Service.Impl.MediaTransferService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaService mediaService;
    private MediaTransferService mediaTransferService;

    @PostMapping(value = "/upload-csv", consumes = { "multipart/form-data" })
    public ResponseEntity<Integer> uploadCsv(
            @RequestPart("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(mediaService.uploadCsv(file));
    }

    @GetMapping("/query/{query}")
    public ResponseEntity<List<MediaDto>> getAllByCriteria(@PathVariable("query") String query) {
        List<MediaDto> media = mediaService.getAllBySimpleQuery(query, query);
        return ResponseEntity.ok(media);
    }

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

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMedia(
            @RequestBody TransferRequest transferRequest) {
        String result = mediaTransferService.transferMedia(
                transferRequest.getMediaId(),
                transferRequest.getFromBranchId(),
                transferRequest.getToBranchId());
        if (result.equals("Media transferred successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    // Return Media
    // @PostMapping("/return")
    // public ResponseEntity<MediaDto> returnMedia(@RequestBody MediaDto mediaDto) {
    // Integer mediaId = mediaDto.getId(); // MediaReturnRequest DTO
    // Integer userId =userDto.getUserId();
    // MediaDto updateMedia = mediaService.returnMedia(mediaId,userId);
    // return new ResponseEntity<>(updateMedia, HttpStatus.CREATED);
    // }
}
