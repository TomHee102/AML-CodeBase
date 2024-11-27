package com.aml.database.DataTransferObject;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BranchDto {

    private int id;
    private String Branchname;
    private String location;
    private String City;
    private List<Integer> mediaIds;
}
