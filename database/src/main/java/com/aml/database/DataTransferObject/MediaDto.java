package com.aml.database.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaDto {
    private int id;
    private String author;
    private String title;
    private String description;
    private String category;
    private String publisher;
    private int year;
    private int branchId;
}
