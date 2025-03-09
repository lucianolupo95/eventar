package com.lucianolupo.eventar.service;

import com.lucianolupo.eventar.models.Event;
import com.lucianolupo.eventar.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // 🔹 Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // 🔹 Get event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // 🔹 Create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> updateEvent(Long id, Event newEventData) {
        return eventRepository.findById(id).map(event -> {
            if (newEventData.getDate() != null)
                event.setDate(newEventData.getDate());
            if (newEventData.getEventTypeId() != null)
                event.setEventTypeId(newEventData.getEventTypeId());
            if (newEventData.getNoYear() != null)
                event.setNoYear(newEventData.getNoYear());
            if (newEventData.getTitle() != null && !newEventData.getTitle().isEmpty())
                event.setTitle(newEventData.getTitle());
            if (newEventData.getDescription() != null)
                event.setDescription(newEventData.getDescription());
            if (newEventData.getImageUrl() != null)
                event.setImageUrl(newEventData.getImageUrl());
            if (newEventData.getVisible() != null)
                event.setVisible(newEventData.getVisible());

            return eventRepository.save(event);
        });
    }

    // 🔹 Delete an event
    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
