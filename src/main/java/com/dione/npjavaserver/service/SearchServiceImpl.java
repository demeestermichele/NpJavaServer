package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.ChapterDAO;
import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dao.EventDAO;
import com.dione.npjavaserver.dao.PlotDAO;
import com.dione.npjavaserver.dto.SearchDTO;
import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Event;
import com.dione.npjavaserver.model.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private CharacDAO characDAO;

    @Autowired
    private ChapterDAO chapterDAO;

    @Autowired
    private PlotDAO plotDAO;

    @Autowired
    private EventDAO eventDAO;


    public SearchServiceImpl(CharacDAO characDAO, ChapterDAO chapterDAO, PlotDAO plotDAO, EventDAO eventDAO) {
        this.characDAO = characDAO;
        this.chapterDAO = chapterDAO;
        this.plotDAO = plotDAO;
        this.eventDAO = eventDAO;
    }

    @Override //FIXME is this really necessary to have Plot with it as well, that would cause recursion?
    public List<SearchDTO> getAll() {
        List<Charac> characs = characDAO.findAll();
        List<Chapter> chapters = chapterDAO.findAll();
        List<SearchDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < characs.size(); i++) {
            Charac charac = characs.get(i);
            Chapter chapter = chapters.get(i);

            SearchDTO searchDTO = new SearchDTO();
            searchDTO.setChapterId(chapter.getId());
            searchDTO.setCharacterId(charac.getId());
            dtoList.add(searchDTO);
        }

        return dtoList;
    }

    @Override
    public List<SearchDTO> getChaptersByCharacterId(Long id) {
        Charac characs = characDAO.getReferenceById(id);
        Set<Chapter> chapterList = characs.getChapterSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Chapter chap : chapterList) {
            SearchDTO chapterDTO = new SearchDTO();
            chapterDTO.setCharacterId(id);
            chapterDTO.setChapterId(chap.getId());
            chapterDTO.setChapterName(chap.getName());
            chapterDTO.setCharacterName(characs.getFirstName() + " " + characs.getLastName());
            dto.add(chapterDTO);

        }
        return dto;
    }

    @Override
    public List<SearchDTO> getCharactersByChapterId(Long id) {
        Chapter chapter = chapterDAO.getReferenceById(id);
        Set<Charac> characList = chapter.getCharacterSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Charac charac : characList) {
            SearchDTO chapterDTO = new SearchDTO();
            chapterDTO.setChapterId(id);
            chapterDTO.setCharacterId(charac.getId());
            chapterDTO.setCharacterName(charac.getFirstName() + " " + charac.getLastName());
            chapterDTO.setChapterName(chapter.getName());
            dto.add(chapterDTO);
        }
        return dto;
    }

    @Override
    public List<SearchDTO> getCharactersByPlotId(Long id) {
        Plot plot = plotDAO.getReferenceById(id);
        Set<Charac> characList = plot.getCharacterSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Charac charac : characList) {
            SearchDTO plotDTO = new SearchDTO();
            plotDTO.setPlotId(id);
            plotDTO.setCharacterId(charac.getId());
            plotDTO.setCharacterName(charac.getFirstName() + " " + charac.getLastName());
            plotDTO.setPlotName(plot.getName());
            dto.add(plotDTO);
        }
        return dto;
    }

    //TODO testing
    @Override
    public List<SearchDTO> getCharactersByEventId(Long id) {
        Event event = eventDAO.getReferenceById(id);
        Set<Charac> characList = event.getCharacterSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Charac charac : characList) {
            SearchDTO eventDTO = new SearchDTO();
            eventDTO.setEventId(id);
            eventDTO.setCharacterId(charac.getId());
            eventDTO.setCharacterName(charac.getFirstName() + " " + charac.getLastName());
            eventDTO.setEventName(event.getName());
            dto.add(eventDTO);
        }
        return dto;
    }

    @Override
    public List<SearchDTO> getPlotsByCharacterId(Long id) {
        Charac characs = characDAO.getReferenceById(id);
        Set<Plot> plots = characs.getPlotSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Plot plot : plots) {
            SearchDTO plotDTO = new SearchDTO();
            plotDTO.setCharacterId(id);
            plotDTO.setChapterId(plot.getId());
            plotDTO.setChapterName(plot.getName());
            plotDTO.setCharacterName(characs.getFirstName() + " " + characs.getLastName());
            dto.add(plotDTO);

        }
        return dto;
    }

    @Override
    public List<SearchDTO> getChaptersByPlotId(Long id) {
        Plot plot = plotDAO.getReferenceById(id);
        Set<Chapter> chapterSet = plot.getChapterSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Chapter chapter : chapterSet) {
            SearchDTO plotDTO = new SearchDTO();
            plotDTO.setPlotId(id);
            plotDTO.setChapterId(chapter.getId());
            plotDTO.setChapterName(chapter.getName());
            plotDTO.setPlotName(plot.getName());
            dto.add(plotDTO);
        }
        return dto;
    }

    //TODO testing
    @Override
    public List<SearchDTO> getChaptersByEventId(Long id) {
        Event event = eventDAO.getReferenceById(id);
        Set<Chapter> chapterSet = event.getChapterSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Chapter chapter : chapterSet) {
            SearchDTO chapterDto = new SearchDTO();
            chapterDto.setEventId(id);
            chapterDto.setChapterId(chapter.getId());
            chapterDto.setChapterName(chapter.getName());
            dto.add(chapterDto);
        }
        return dto;
    }

    @Override
    public List<SearchDTO> getPlotsByChapterId(Long id) {
        Chapter chapter = chapterDAO.getReferenceById(id);
        Set<Plot> plotList = chapter.getPlotSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Plot plot : plotList) {
            SearchDTO chapterDTO = new SearchDTO();
            chapterDTO.setChapterId(id);
            chapterDTO.setChapterName(chapter.getName());
            chapterDTO.setPlotId(plot.getId());
            chapterDTO.setPlotName(plot.getName());
            dto.add(chapterDTO);
        }
        return dto;
    }
//TODO testing
    @Override
    public List<SearchDTO> getPlotsByEventId(Long id) {
        Event event = eventDAO.getReferenceById(id);
        Set<Plot> plotList = event.getPlotSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Plot plot : plotList) {
            SearchDTO plotDTO = new SearchDTO();
            plotDTO.setEventId(id);
            plotDTO.setEventName(event.getName());
            plotDTO.setPlotId(plot.getId());
            plotDTO.setPlotName(plot.getName());
            dto.add(plotDTO);
        }
        return dto;
    }

    @Override
    public List<SearchDTO> getEventsByChapterId(Long id) {
        Chapter chapter = chapterDAO.getReferenceById(id);
        Set<Event> eventList = chapter.getEventSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Event event : eventList) {
            SearchDTO chapterDTO = new SearchDTO();
            chapterDTO.setChapterId(id);
            chapterDTO.setChapterName(chapter.getName());
            chapterDTO.setEventId(event.getId());
            chapterDTO.setEventName(event.getName());
            dto.add(chapterDTO);
        }
        return dto;
    }
//TODO testing
    @Override
    public List<SearchDTO> getEventsByPlotId(Long id) {
        Plot plot = plotDAO.getReferenceById(id);
        Set<Event> eventSet = plot.getEventSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Event event : eventSet) {
            SearchDTO plotDTO = new SearchDTO();
            plotDTO.setPlotId(id);
            plotDTO.setEventId(event.getId());
            plotDTO.setEventName(event.getName());
            plotDTO.setPlotName(plot.getName());
            dto.add(plotDTO);
        }
        return dto;
    }

    @Override
    public List<SearchDTO> getEventsByCharacterId(Long id) {
        Charac characs = characDAO.getReferenceById(id);
        Set<Event> events = characs.getEventSet();
        List<SearchDTO> dto = new ArrayList<>();
        for (Event event : events) {
            SearchDTO eventDTO = new SearchDTO();
            eventDTO.setCharacterId(id);
            eventDTO.setEventId(event.getId());
            eventDTO.setEventName(event.getName());
            eventDTO.setCharacterName(characs.getFirstName() + " " + characs.getLastName());
            dto.add(eventDTO);

        }
        return dto;
    }

    private SearchDTO mapToCharacDto(Charac charac) {
        SearchDTO dto = new SearchDTO();
        dto.setCharacterId(charac.getId());
        dto.setCharacterName(charac.getFirstName());
        return dto;
    }

    //TODO mapToDTO
    private Chapter mapToChapter(SearchDTO searchDTO) {
        Chapter chapter = new Chapter();
        chapter.setId(searchDTO.getChapterId());
        chapter.setName(searchDTO.getChapterName());
        return chapter;
    }

    //TODO mapToDTO
    private Charac mapToCharacter(SearchDTO searchDTO) {
        Charac character = new Charac();
        character.setId(searchDTO.getCharacterId());
        character.setFirstName(searchDTO.getCharacterName());
        return character;
    }
}
