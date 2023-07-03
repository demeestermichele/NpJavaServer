package com.dione.npjavaserver.dao;

import com.dione.npjavaserver.model.Book;
import com.dione.npjavaserver.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDAO extends JpaRepository<Chapter, Long> {

    List<Chapter> getChaptersByBook(Book bookIndex);
}
