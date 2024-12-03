package com.aml.database.Mapper;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.Entity.Branch;
import com.aml.database.Entity.Media;

public class MediaMapper {

    public static MediaDto mapToMediaDto(Media media) {
        return new MediaDto(
                media.getId(),
                media.getAuthor(),
                media.getTitle(),
                media.getDescription(),
                media.getCategory(),
                media.getPublisher(),
                media.getYear(),
                media.getBranch() != null ? media.getBranch().getId() : 0
        // media.getMediaTransferRequest() != null ?
        // media.getMediaTransferRequest().size() : 0
        );
    }

    public static Media mapToMedia(MediaDto mediaDto, Branch branch) {
        Media media = new Media();
        media.setId(mediaDto.getId());
        media.setAuthor(mediaDto.getAuthor());
        media.setTitle(mediaDto.getTitle());
        media.setDescription(mediaDto.getDescription());
        media.setCategory(mediaDto.getCategory());
        media.setPublisher(mediaDto.getPublisher());
        media.setYear(mediaDto.getYear());
        media.setBranch(branch);
        // media.setMediaTransferRequest(new ArrayList<>());
        return media;
    }
}
