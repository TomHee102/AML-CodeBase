package com.aml.database.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.database.Entity.Branch;
import com.aml.database.Entity.Media;
import com.aml.database.Repository.BranchRepo;
import com.aml.database.Repository.MediaRepo;

@Service
public class MediaTransferService {

    @Autowired
    private MediaRepo mediaRepository;

    @Autowired
    private BranchRepo branchRepository;

    public String transferMedia(int mediaId, int fromBranchId, int toBranchId) {
        // Validate media exists
        Optional<Media> mediaOptional = mediaRepository.findById(mediaId);
        if (mediaOptional.isEmpty()) {
            return "Media not found";
        }

        // Validate branches exist
        Optional<Branch> fromBranchOptional = branchRepository.findById(fromBranchId);
        Optional<Branch> toBranchOptional = branchRepository.findById(toBranchId);

        if (fromBranchOptional.isEmpty() || toBranchOptional.isEmpty()) {
            return "One or both branches not found";
        }

        Branch fromBranch = fromBranchOptional.get();
        Branch toBranch = toBranchOptional.get();

        // Check if both branches are in the same location
        if (!fromBranch.getLocation().equalsIgnoreCase(toBranch.getLocation())) {
            return "Branches must be in the same location";
        }

        // Perform the transfer
        Media media = mediaOptional.get();
        media.setBranch(toBranch);
        mediaRepository.save(media);

        return "Media transferred successfully";
    }
}
