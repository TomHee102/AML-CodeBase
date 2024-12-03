package com.aml.database.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aml.database.DataTransferObject.MediaDto;

public interface MediaService {

    public Integer uploadCsv(MultipartFile file) throws IOException;

    List<MediaDto> getAllBySimpleQuery(String title, String author);

    MediaDto createMedia(MediaDto mediaDto);

    MediaDto getMediaById(Integer mediaId);

    List<MediaDto> getAllMedia();
    // MediaDto returnMedia(int mediaId, int userId);
}
