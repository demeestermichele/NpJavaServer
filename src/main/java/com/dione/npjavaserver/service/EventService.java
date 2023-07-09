package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.EventDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface EventService {
    List<EventDTO> getAll();

    EventDTO getEventById(Long id) throws ChangeSetPersister.NotFoundException;

    EventDTO createEvent(EventDTO eventDto);

    EventDTO updateEvent(Long id, EventDTO eventDto) throws ChangeSetPersister.NotFoundException;

    void deleteEvent(Long id) throws ChangeSetPersister.NotFoundException;
    
}
