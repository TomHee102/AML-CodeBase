package com.aml.database.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.Entity.Branch;
import com.aml.database.Entity.Media;
import com.aml.database.Exception.ResourceNotFoundException;
import com.aml.database.Mapper.MediaMapper;
import com.aml.database.Repository.BranchRepo;
import com.aml.database.Repository.MediaRepo;
import com.aml.database.Service.MediaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MediaServiceImpl implements MediaService {

    private MediaRepo mediaRepo;
    private BranchRepo branchRepo;

    @Override
    public MediaDto createMedia(MediaDto mediaDto) {

        //for media creation, need to add branch name
        Branch branch = branchRepo.findById(mediaDto.getBranchId()).orElseThrow(() -> new ResourceNotFoundException("Branch not found with id : " + mediaDto.getBranchId()));
        Media media = MediaMapper.mapToMedia(mediaDto, branch);
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
    
    //transfer media
    @Override
    public MediaDto transferMedia(int mediaId, int newBranchId) {
        Media media = mediaRepo.findById(mediaId).orElseThrow(() -> new ResourceNotFoundException("Media not found with id : " + mediaId));
        Branch newBranch = branchRepo.findById(newBranchId).orElseThrow(() -> new ResourceNotFoundException("Branch not found with id : " + newBranchId));

        // Update the branch of the media
        media.setBranch(newBranch);
        Media updatedMedia = mediaRepo.save(media);

        return MediaMapper.mapToMediaDto(updatedMedia);
    }


}
