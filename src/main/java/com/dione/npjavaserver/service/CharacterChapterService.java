package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.CharacterChapterDTO;

import java.util.List;

public interface CharacterChapterService {
    List<CharacterChapterDTO> getAll();
    List<CharacterChapterDTO> getCharacterChapterByCharacterId(Long id);
    List<CharacterChapterDTO> getCharacterChapterByChapterId(Long id);
}
