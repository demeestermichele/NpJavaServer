package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.CharacterChapterPlotDTO;

import java.util.List;

public interface CharacterChapterPlotService {
    List<CharacterChapterPlotDTO> getAll();
    List<CharacterChapterPlotDTO> getChaptersByCharacterId(Long id);
    List<CharacterChapterPlotDTO> getChaptersByPlotId(Long id);
    List<CharacterChapterPlotDTO> getCharactersByChapterId(Long id);
    List<CharacterChapterPlotDTO> getCharactersByPlotId(Long id);
}

