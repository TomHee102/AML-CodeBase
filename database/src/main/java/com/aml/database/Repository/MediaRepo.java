package com.aml.database.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aml.database.Entity.Media;

@Repository
public interface MediaRepo {

    public List<Media> getMediaData();
}
