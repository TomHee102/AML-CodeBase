package com.aml.database.Service;

import java.util.List;

import com.aml.database.DataTransferObject.MediaDto;

public interface MediaService {
    MediaDto createMedia(MediaDto mediaDto);

    MediaDto getMediaById(Integer mediaId);

    List<MediaDto> getAllMedia();
<<<<<<< HEAD

    // hello
=======
    
    MediaDto transferMedia(int mediaId, int newBranchId);

   
>>>>>>> 6938233 (Initial commit)
}
