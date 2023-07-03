package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.ChapterDAO;
import com.dione.npjavaserver.dto.ChapterDTO;
import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDAO chapterDAO;

    private ChapterDTO mapToDto(Chapter chapter) {
        ChapterDTO chapterDTO = new ChapterDTO();
        chapterDTO.setName(chapter.getName());
        chapterDTO.setNumber(chapter.getNumber());
        chapterDTO.setVersion(chapter.getVersion());
        chapterDTO.setDescription(chapter.getDescription());
        chapterDTO.setBook(chapter.getBook());
        return chapterDTO;
    }

    private Chapter mapToEntity(ChapterDTO chapterDTO) {
        Chapter chapter = new Chapter();
        chapter.setName(chapterDTO.getName());
        chapter.setNumber(chapterDTO.getNumber());
        chapter.setVersion(chapterDTO.getVersion());
        chapter.setDescription(chapterDTO.getDescription());
        chapter.setBook(chapterDTO.getBook());
        return chapter;
    }


    @Override
    public List<ChapterDTO> getAll() {
        List<Chapter> chapters = chapterDAO.findAll();
        List<ChapterDTO> chapterDTOList = new ArrayList<>();
        for (Chapter chapter : chapters) {
            chapterDTOList.add(new ChapterDTO(chapter.getName(), chapter.getNumber(), chapter.getVersion(), chapter.getDescription(), chapter.getBook()));
        }
        return chapterDTOList;
    }

    @Override
    public ChapterDTO getChapterById(Long id) throws ChangeSetPersister.NotFoundException {
        Chapter chapter = chapterDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return mapToDto(chapter);
    }

    @Override
    public ChapterDTO createChapter(ChapterDTO chapterDTO) {
        Chapter chapter = mapToEntity(chapterDTO);
        Chapter createdChapter = chapterDAO.save(chapter);
        return mapToDto(createdChapter);
    }

    @Override
    public ChapterDTO updateChapter(Long id, ChapterDTO chapterDTO) throws ChangeSetPersister.NotFoundException {
        Chapter chapter = chapterDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        chapter.setName(chapterDTO.getName());
        chapter.setNumber(chapterDTO.getNumber());
        chapter.setVersion(chapterDTO.getVersion());
        chapter.setDescription(chapterDTO.getDescription());
        chapter.setBook(chapterDTO.getBook());
        Chapter updatedChapter = chapterDAO.save(chapter);
        return mapToDto(updatedChapter);
    }

    @Override
    public void deleteChapter(Long id) throws ChangeSetPersister.NotFoundException {
            Chapter charac = chapterDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            chapterDAO.delete(charac);
        }
    }

