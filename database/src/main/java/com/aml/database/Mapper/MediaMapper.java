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
                media.getYear(),
                media.getBranch() != null ? media.getBranch().getId() : 0);
              
    }

    public static Media mapToMedia(MediaDto mediaDto, Branch branch) {
        return new Media(
                mediaDto.getId(),
                mediaDto.getAuthor(),
                mediaDto.getTitle(),
                mediaDto.getYear(),
                branch);
    }
}
