package com.aml.database.Service.Impl;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaCsvRepresentation {

    @CsvBindByName(column = "Title")
    private String title;

    @CsvBindByName(column = "Authors")
    private String author;

    @CsvBindByName(column = "Category")
    private String category;

    @CsvBindByName(column = "Publisher")
    private String publisher;
}
