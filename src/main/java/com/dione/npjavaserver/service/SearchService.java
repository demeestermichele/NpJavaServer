package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.SearchDTO;

import java.util.List;

public interface SearchService {
    List<SearchDTO> getAll();
    List<SearchDTO> getChaptersByCharacterId(Long id);
    List<SearchDTO> getChaptersByPlotId(Long id);
    List<SearchDTO> getCharactersByChapterId(Long id);
    List<SearchDTO> getCharactersByPlotId(Long id);
    List<SearchDTO> getPlotsByCharacterId(Long id);
    List<SearchDTO> getPlotsByChapterId(Long id);

}

