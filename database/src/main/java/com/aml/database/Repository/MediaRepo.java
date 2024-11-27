package com.aml.database.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aml.database.DataTransferObject.AdminDto;
import com.aml.database.Entity.Media;

public interface MediaRepo extends JpaRepository<Media, Integer> {

    static Optional<AdminDto> findByBranchId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'findByBranchId'");
    }

    static Collection<Media> finadAll() {
     
        throw new UnsupportedOperationException("Unimplemented method 'finadAll'");
    }

    static List<Media> findMediaByAdminCity(String adminCity) {
       
        throw new UnsupportedOperationException("Unimplemented method 'findMediaByAdminCity'");
    }

}

