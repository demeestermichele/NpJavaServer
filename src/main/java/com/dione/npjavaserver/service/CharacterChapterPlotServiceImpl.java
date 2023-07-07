package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.ChapterDAO;
import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dao.PlotDAO;
import com.dione.npjavaserver.dto.CharacterChapterPlotDTO;
import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CharacterChapterPlotServiceImpl implements CharacterChapterPlotService {

    @Autowired
    private CharacDAO characDAO;

    @Autowired
    private ChapterDAO chapterDAO;

    @Autowired
    private PlotDAO plotDAO;


    public CharacterChapterPlotServiceImpl(CharacDAO charac, ChapterDAO chapter, PlotDAO plot) {
        this.characDAO = charac;
        this.chapterDAO = chapter;
        this.plotDAO = plot;
    }

    @Override //FIXME is this really necessary to have Plot with it as well, that would cause recursion?
    public List<CharacterChapterPlotDTO> getAll() {
        List<Charac> characs = characDAO.findAll();
        List<Chapter> chapters = chapterDAO.findAll();
        List<CharacterChapterPlotDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < characs.size(); i++) {
            Charac charac = characs.get(i);
            Chapter chapter = chapters.get(i);

            CharacterChapterPlotDTO characterChapterPlotDTO = new CharacterChapterPlotDTO();
            characterChapterPlotDTO.setChapterId(chapter.getId());
            characterChapterPlotDTO.setCharacterId(charac.getId());
            dtoList.add(characterChapterPlotDTO);
        }

        return dtoList;
    }

    @Override
    public List<CharacterChapterPlotDTO> getChaptersByCharacterId(Long id) {
        Charac characs = characDAO.getReferenceById(id);
        Set<Chapter> chapterList = characs.getChapterSet();
        List<CharacterChapterPlotDTO> dto = new ArrayList<>();
        for (Chapter chap : chapterList) {
            CharacterChapterPlotDTO chapterDTO = new CharacterChapterPlotDTO();
            chapterDTO.setCharacterId(id);
            chapterDTO.setChapterId(chap.getId());
            chapterDTO.setChapterName(chap.getName());
            chapterDTO.setCharacterName(characs.getFirstName() + " " + characs.getLastName());
            dto.add(chapterDTO);

        }
        return dto;
    }

    @Override
    public List<CharacterChapterPlotDTO> getCharactersByChapterId(Long id) {
        Chapter chapter = chapterDAO.getReferenceById(id);
        Set<Charac> characList = chapter.getCharacterSet();
        List<CharacterChapterPlotDTO> dto = new ArrayList<>();
        for (Charac charac : characList) {
            CharacterChapterPlotDTO chapterDTO = new CharacterChapterPlotDTO();
            chapterDTO.setChapterId(id);
            chapterDTO.setCharacterId(charac.getId());
            chapterDTO.setCharacterName(charac.getFirstName() + " " + charac.getLastName());
            chapterDTO.setChapterName(chapter.getName());
            dto.add(chapterDTO);
        }
        return dto;
    }

    @Override
    public List<CharacterChapterPlotDTO> getCharactersByPlotId(Long id) {
        Plot plot = plotDAO.getReferenceById(id);
        Set<Charac> characList = plot.getCharacterSet();
        List<CharacterChapterPlotDTO> dto = new ArrayList<>();
        for (Charac charac : characList) {
            CharacterChapterPlotDTO plotDTO = new CharacterChapterPlotDTO();
            plotDTO.setPlotId(id);
            plotDTO.setCharacterId(charac.getId());
            plotDTO.setCharacterName(charac.getFirstName() + " " + charac.getLastName());
            plotDTO.setPlotName(plot.getName());
            dto.add(plotDTO);
        }
        return dto;
    }

    @Override
    public List<CharacterChapterPlotDTO> getPlotsByCharacterId(Long id) {
        Charac characs = characDAO.getReferenceById(id);
        Set<Plot> plots = characs.getPlotSet();
        List<CharacterChapterPlotDTO> dto = new ArrayList<>();
        for (Plot plot : plots) {
            CharacterChapterPlotDTO plotDTO = new CharacterChapterPlotDTO();
            plotDTO.setCharacterId(id);
            plotDTO.setChapterId(plot.getId());
            plotDTO.setChapterName(plot.getName());
            plotDTO.setCharacterName(characs.getFirstName() + " " + characs.getLastName());
            dto.add(plotDTO);

        }
        return dto;
    }

    @Override
    public List<CharacterChapterPlotDTO> getChaptersByPlotId(Long id) {
        Plot plot = plotDAO.getReferenceById(id);
        Set<Chapter> chapterSet = plot.getChapterSet();
        List<CharacterChapterPlotDTO> dto = new ArrayList<>();
        for (Chapter chapter : chapterSet) {
            CharacterChapterPlotDTO plotDTO = new CharacterChapterPlotDTO();
            plotDTO.setPlotId(id);
            plotDTO.setChapterId(chapter.getId());
            plotDTO.setChapterName(chapter.getName());
            plotDTO.setPlotName(plot.getName());
            dto.add(plotDTO);
        }
        return dto;
    }

    @Override
    public List<CharacterChapterPlotDTO> getPlotsByChapterId(Long id) {
        Chapter chapter = chapterDAO.getReferenceById(id);
        Set<Plot> plotList = chapter.getPlotSet();
        List<CharacterChapterPlotDTO> dto = new ArrayList<>();
        for (Plot plot : plotList) {
            CharacterChapterPlotDTO chapterDTO = new CharacterChapterPlotDTO();
            chapterDTO.setChapterId(id);
            chapterDTO.setChapterName(chapter.getName());
            chapterDTO.setPlotId(plot.getId());
            chapterDTO.setPlotName(plot.getName());
            dto.add(chapterDTO);
        }
        return dto;
    }

    private CharacterChapterPlotDTO mapToCharacDto(Charac charac) {
        CharacterChapterPlotDTO dto = new CharacterChapterPlotDTO();
        dto.setCharacterId(charac.getId());
        dto.setCharacterName(charac.getFirstName());
        return dto;
    }

    //TODO mapToDTO
    private Chapter mapToChapter(CharacterChapterPlotDTO characterChapterPlotDTO) {
        Chapter chapter = new Chapter();
        chapter.setId(characterChapterPlotDTO.getChapterId());
        chapter.setName(characterChapterPlotDTO.getChapterName());
        return chapter;
    }

    //TODO mapToDTO
    private Charac mapToCharacter(CharacterChapterPlotDTO characterChapterPlotDTO) {
        Charac character = new Charac();
        character.setId(characterChapterPlotDTO.getCharacterId());
        character.setFirstName(characterChapterPlotDTO.getCharacterName());
        return character;
    }
}
