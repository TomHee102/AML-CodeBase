package com.aml.database.Service.Impl;

import org.springframework.stereotype.Service;

import com.aml.database.Dto.MediaDto;
import com.aml.database.Entity.Media;
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
        return MediaMapper.maptoMediaDto(savedMedia);
    }

}
