package com.lucianolupo.eventar.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import com.lucianolupo.eventar.models.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest // Loads only JPA-related components
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Uses PostgreSQL instead of H2
@Transactional // Rolls back changes after each test
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    void testSaveAndFindEvent() {
        // Arrange
        Event event = new Event(LocalDate.of(2023, 12, 27), false, 1, "JUnit Test Event");

        // Act
        Event savedEvent = eventRepository.save(event);

        // Assert
        assertNotNull(savedEvent.getId());
        List<Event> events = eventRepository.findAll();
        assertFalse(events.isEmpty());

        System.out.println("✅ Test Passed: Event Saved and Retrieved Successfully!");
    }
}
