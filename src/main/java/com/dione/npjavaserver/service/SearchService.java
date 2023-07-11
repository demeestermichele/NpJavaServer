package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.SearchDTO;

import java.util.List;

public interface SearchService {
    List<SearchDTO> getAll();

    //Chapters
    List<SearchDTO> getChaptersByCharacterId(Long id);
    List<SearchDTO> getChaptersByPlotId(Long id);
    List<SearchDTO> getChaptersByEventId(Long id);

    //Characters
    List<SearchDTO> getCharactersByChapterId(Long id);
    List<SearchDTO> getCharactersByPlotId(Long id);
    List<SearchDTO> getCharactersByEventId(Long id);

    //Plots
    List<SearchDTO> getPlotsByCharacterId(Long id);
    List<SearchDTO> getPlotsByChapterId(Long id);
    List<SearchDTO> getPlotsByEventId(Long id);

    //Events
    List<SearchDTO> getEventsByChapterId(Long id);
    List<SearchDTO> getEventsByPlotId(Long id);
    List<SearchDTO> getEventsByCharacterId(Long id);


}

