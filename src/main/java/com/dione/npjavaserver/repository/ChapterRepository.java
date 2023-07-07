package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.dto.ChapterDTO;
import com.dione.npjavaserver.model.Book;
import com.dione.npjavaserver.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

    public Chapter findChapterById(Long id);
    Chapter findChaptersByBook(Book book);

    public Set<Chapter> findChaptersByNameContaining(String name);

    public Chapter findChaptersByNumber(float number);

}
