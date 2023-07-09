package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.EventDAO;
import com.dione.npjavaserver.dto.EventDTO;
import com.dione.npjavaserver.model.Event;
import com.dione.npjavaserver.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    private EventDTO mapToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(event.getName());
        eventDTO.setType(event.getType());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setDescription(event.getDescription());
        return eventDTO;
    }

    private Event mapToEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setType(eventDTO.getType());
        event.setLocation(eventDTO.getLocation());
        event.setDescription(eventDTO.getDescription());
        return event;
    }


    @Override
    public List<EventDTO> getAll() {
        List<Event> events = eventDAO.findAll();
        List<EventDTO> dtos = new ArrayList<>();
        for (Event event : events) {
            dtos.add(new EventDTO(event.getName(), event.getType(), event.getLocation(), event.getDescription()));
        }
        return dtos;
    }

    @Override
    public EventDTO getEventById(Long id) throws ChangeSetPersister.NotFoundException {
        Event event = eventDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return mapToDto(event);
    }

    @Override
    public EventDTO createEvent(EventDTO eventDto) {
        Event event = mapToEntity(eventDto);
        Event createdEvent = eventDAO.save(event);
        return mapToDto(createdEvent);
    }

    @Override
    public EventDTO updateEvent(Long id, EventDTO eventDto) throws ChangeSetPersister.NotFoundException {
        Event event = eventDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        event.setName(eventDto.getName());
        event.setType(eventDto.getType());
        event.setLocation(event.getLocation());
        event.setDescription(eventDto.getDescription());
        Event updatedEvent = eventDAO.save(event);
        return mapToDto(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) throws ChangeSetPersister.NotFoundException {
        Event event = eventDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        eventDAO.delete(event);
    }
}
