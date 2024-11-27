package com.aml.database.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.aml.database.DataTransferObject.BranchDto;
import com.aml.database.Entity.Branch;
import com.aml.database.Entity.Media;

public class BranchMapper {

    public static BranchDto mapToBranchDto(Branch branch) {

        List<Integer> mediaIds = branch.getMedia() != null ? 
            branch.getMedia().stream().map(Media::getId).collect(Collectors.toList()) : List.of();
    
        return new BranchDto(
                branch.getId(),
                branch.getBranchname(),
                branch.getLocation(),
                branch.getCity(),
                mediaIds
        );
    }

    public static Branch mapToBranch(BranchDto branchDto, List<Media> media) {
        if (branchDto == null) {
            return null;
        }
        Branch branch = new Branch();
        branch.setId(branchDto.getId());
        branch.setBranchname(branchDto.getBranchname());
        branch.setLocation(branchDto.getLocation());
        branch.setCity(branchDto.getCity());
        branch.setMedia(media); 

        return branch;
    }
}
