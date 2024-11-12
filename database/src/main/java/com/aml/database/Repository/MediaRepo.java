package com.aml.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aml.database.Entity.Media;

public interface MediaRepo extends JpaRepository<Media, Integer> {
}
