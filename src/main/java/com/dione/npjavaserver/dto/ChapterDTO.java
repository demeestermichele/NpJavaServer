package com.dione.npjavaserver.dto;

import com.dione.npjavaserver.model.Book;
import com.dione.npjavaserver.model.Chapter;

import java.io.Serializable;

/**
 * A DTO for the {@link Chapter} entity
 */
public class ChapterDTO implements Serializable {
    private String name;
    private Integer number;
    private float version;
    private String description;
    private Book book;

    public ChapterDTO() {
    }

    public ChapterDTO(String name, String description, Book book) {
        this.name = name;
        this.description = description;
        this.book = book;
    }

    public ChapterDTO(String name, Integer number, float version, String description, Book book) {
        this.name = name;
        this.number = number;
        this.version = version;
        this.description = description;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
