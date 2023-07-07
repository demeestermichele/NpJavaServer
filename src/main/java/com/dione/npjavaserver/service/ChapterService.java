package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.ChapterDTO;
import com.dione.npjavaserver.model.Book;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ChapterService {

    List<ChapterDTO> getAll();

    ChapterDTO getChapterById(Long id) throws ChangeSetPersister.NotFoundException;
    List<ChapterDTO> getChapterByBook(Book bookIndex) throws ChangeSetPersister.NotFoundException;

    ChapterDTO createChapter(ChapterDTO chapterDTO);
    ChapterDTO updateChapter(Long id, ChapterDTO chapterDTO) throws ChangeSetPersister.NotFoundException;
    void deleteChapter(Long id) throws ChangeSetPersister.NotFoundException;
}
