package com.aml.database.Service;

import java.util.List;

import com.aml.database.DataTransferObject.MediaDto;

public interface MediaService {

    List<MediaDto> getAllBySimpleQuery(String title, String author);
    MediaDto createMedia(MediaDto mediaDto);
    MediaDto getMediaById(Integer mediaId);
    List<MediaDto> getAllMedia();
     // MediaDto returnMedia(int mediaId, int userId);
}
