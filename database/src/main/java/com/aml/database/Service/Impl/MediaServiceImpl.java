package com.aml.database.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.Entity.Media;
import com.aml.database.Exception.ResourceNotFoundException;
import com.aml.database.Mapper.MediaMapper;
import com.aml.database.Repository.MediaRepo;
import com.aml.database.Service.MediaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MediaServiceImpl implements MediaService {

    private MediaRepo mediaRepo;

    @Override
    public MediaDto createMedia(MediaDto mediaDto) {

        Media media = MediaMapper.mapToMedia(mediaDto);
        Media savedMedia = mediaRepo.save(media);
        return MediaMapper.mapToMediaDto(savedMedia);
    }

    @Override
    public MediaDto getMediaById(Integer mediaId) {
        Media media = mediaRepo.findById(mediaId)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id : " + mediaId));

        return MediaMapper.mapToMediaDto(media);
    }

    @Override
    public List<MediaDto> getAllMedia() {
        List<Media> allMedia = mediaRepo.findAll();
        return allMedia.stream().map((media) -> MediaMapper.mapToMediaDto(media)).collect(Collectors.toList());
    }

}
