package com.aml.database.Mapper;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.Entity.Media;

public class MediaMapper {

    public static MediaDto mapToMediaDto(Media media) {
        return new MediaDto(
                media.getId(),
                media.getAuthor(),
                media.getTitle(),
                media.getYear());
    }

    public static Media mapToMedia(MediaDto mediaDto) {
        return new Media(
                mediaDto.getId(),
                mediaDto.getAuthor(),
                mediaDto.getTitle(),
                mediaDto.getYear());
    }
}
