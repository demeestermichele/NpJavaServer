package com.dione.npjavaserver.dto;

import com.dione.npjavaserver.model.Book;
import com.dione.npjavaserver.model.Plot;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link Plot} entity
 */
public class PlotDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Date revision;

    private Book book;

    public PlotDTO() {
    }

    public PlotDTO(Long id, String name, String description, Book book) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRevision() {
        return revision;
    }

    public void setRevision(Date revision) {
        this.revision = revision;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
