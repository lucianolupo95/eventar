package com.lucianolupo.eventar.controller;

import com.lucianolupo.eventar.models.Event;
import com.lucianolupo.eventar.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // 🔹 Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // 🔹 Get an event by ID
    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // 🔹 Create a new event
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // 🔹 Update an event
    @PutMapping("/{id}")
    public Optional<Event> updateEvent(@PathVariable Long id, @RequestBody Event newEventData) {
        return eventService.updateEvent(id, newEventData);
    }

    // 🔹 Delete an event
    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }
}
