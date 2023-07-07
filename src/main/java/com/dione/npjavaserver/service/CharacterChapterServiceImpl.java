package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.ChapterDAO;
import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dto.CharacterChapterDTO;
import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.repository.CharacterChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CharacterChapterServiceImpl implements CharacterChapterService {

    @Autowired
    private CharacDAO characDAO;

    @Autowired
    private ChapterDAO chapterDAO;

    @Autowired
    private CharacterChapterRepository chapterRepository;

    public CharacterChapterServiceImpl(CharacDAO charac, ChapterDAO chapter) {
        this.characDAO = charac;
        this.chapterDAO = chapter;
    }

    @Override
    public List<CharacterChapterDTO> getAll() {
        List<Charac> characs = characDAO.findAll();
        List<Chapter> chapters = chapterDAO.findAll();
        List<CharacterChapterDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < characs.size(); i++) {
            Charac charac = characs.get(i);
            Chapter chapter = chapters.get(i);

            CharacterChapterDTO characterChapterDTO = new CharacterChapterDTO();
            characterChapterDTO.setChapterId(chapter.getId());
            characterChapterDTO.setCharacterId(charac.getId());
            dtoList.add(characterChapterDTO);
        }

        return dtoList;
    }

    @Override
    public List<CharacterChapterDTO> getCharacterChapterByCharacterId(Long id) {
        return null;
    }

    @Override
    public List<CharacterChapterDTO> getCharacterChapterByChapterId(Long id) {
        Charac characs = characDAO.getReferenceById(id);
        Set<Chapter> chapterList = characs.getChapterSet();
        List<CharacterChapterDTO> dto = new ArrayList<>();
        for (Chapter chap : chapterList) {
            CharacterChapterDTO chapterDTO = new CharacterChapterDTO();
            chapterDTO.setCharacterId(id);
            chapterDTO.setChapterId(chap.getId());
            chapterDTO.setChapterName(chap.getName());
            dto.add(chapterDTO);

        }
        return dto;
    }

    private CharacterChapterDTO mapToDto(Charac charac) {
        CharacterChapterDTO dto = new CharacterChapterDTO();
        dto.setCharacterId(charac.getId());
        dto.setCharacterName(charac.getFirstName());
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
