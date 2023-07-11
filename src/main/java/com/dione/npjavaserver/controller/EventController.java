package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.dto.EventDTO;
import com.dione.npjavaserver.dto.SearchDTO;
import com.dione.npjavaserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private CharacService characService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private PlotService plotService;

    @Autowired
    private EventService eventService;


    /**
     * List of all Events
     **/
    @GetMapping("/")
    public ResponseEntity<List<EventDTO>> getAll() throws ChangeSetPersister.NotFoundException {
        List<EventDTO> eventDTOs = eventService.getAll();
        return ResponseEntity.ok(eventDTOs);
    }

    /**
     * Get 1 Event using ID
     **/
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO eventDto = null;
        try {
            eventDto = eventService.getEventById(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(eventDto);
    }

    /**
     * Create 1 Event
     **/
    @PostMapping("/create")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDto) throws ChangeSetPersister.NotFoundException {
        EventDTO createdEventDto = eventService.createEvent(eventDto);
        return ResponseEntity.created(URI.create("/event/" + createdEventDto.getId())).body(createdEventDto);
    }

    /**
     * Update 1 EventDTO after finding ID
     **/
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDto) {
        EventDTO updatedEventDTO = null;
        try {
            updatedEventDTO = eventService.updateEvent(id, eventDto);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(updatedEventDTO);
    }

    /**
     * Delete 1 EventDTO using ID
     **/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }


    /**
     * Using the ID of a EventDTO, display all Chapters in which they are present
     *
     * @param id of the character whose chapter list you wish to find.
     * @return list of chapters
     */
    @GetMapping("/{id}/chapters")
    public ResponseEntity<List<SearchDTO>> getChaptersByEventId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {

        try {
            List<SearchDTO> chapters = searchService.getChaptersByEventId(id);
            return ResponseEntity.ok(chapters);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/plots")
    public ResponseEntity<List<SearchDTO>> getPlotsByEventId(@PathVariable Long id) {
        try {
            List<SearchDTO> event = searchService.getPlotsByEventId(id);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}/characters")
    public ResponseEntity<List<SearchDTO>> getCharactersByEventId(@PathVariable Long id) {
        try {
            List<SearchDTO> event = searchService.getCharactersByEventId(id);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
