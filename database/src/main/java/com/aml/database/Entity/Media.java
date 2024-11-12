package com.aml.database.Entity;

public class Media {
    
    int id;
    String title;
    String author;
    int year;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Media(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Media(){
        super();
    }
    
    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + "]";
    }
}
