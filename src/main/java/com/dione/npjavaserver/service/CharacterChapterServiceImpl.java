package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.ChapterDAO;
import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dto.CharacterChapterDTO;
import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterChapterServiceImpl implements CharacterChapterService {

    @Autowired
    private CharacDAO characDAO;

    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    public List<CharacterChapterDTO> getAll() {
        return null;
    }

    @Override
    public List<CharacterChapterDTO> getCharacterChapterByCharacterId(Long id) {
        return null;
    }

    @Override
    public List<CharacterChapterDTO> getCharacterChapterByChapterId(Long id) {
        return null;
    }

    private CharacterChapterDTO mapToDto(Charac charac, Chapter chapter) {
        CharacterChapterDTO dto = new CharacterChapterDTO();
        dto.setCharacterId(charac.getId());
        dto.setCharacterName(charac.getFirstName());
        dto.setChapterId(chapter.getId());
        dto.setChapterName(chapter.getName());
        return dto;
    }

    //TODO mapToEntity
    private Chapter cChapterDTOToEntity(CharacterChapterDTO characterChapterDTO) {
        Chapter chapter = new Chapter();
        chapter.setId(characterChapterDTO.getChapterId());
        chapter.setName(characterChapterDTO.getChapterName());
        return chapter;
    }

    //TODO mapToEntity
    private Charac cCharacterDTOToEntity(CharacterChapterDTO characterChapterDTO) {
        Charac character = new Charac();
        character.setId(characterChapterDTO.getCharacterId());
        character.setFirstName(characterChapterDTO.getCharacterName());
        return character;
    }
}
