package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.EventDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public List<EventDTO> getAll() {
        return null;
    }

    @Override
    public EventDTO getEventById(Long id) throws ChangeSetPersister.NotFoundException {
        return null;
    }

    @Override
    public EventDTO createEvent(EventDTO eventDto) {
        return null;
    }

    @Override
    public EventDTO updateEvent(Long id, EventDTO eventDto) throws ChangeSetPersister.NotFoundException {
        return null;
    }

    @Override
    public void deleteEvent(Long id) throws ChangeSetPersister.NotFoundException {

    }
}
