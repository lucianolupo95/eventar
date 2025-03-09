package com.lucianolupo.eventar.models;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Integer eventTypeId;
    private Boolean noYear;
    private String title;
    private String description;
    private String imageUrl;
    private Boolean visible = true;
    private LocalDateTime creationDate = LocalDateTime.now();

    // JPA requires a no-args constructor
    public Event() {
    }

    // Optional: A constructor for quick object creation
    public Event(LocalDate date, Boolean noYear, Integer eventTypeId, String title) {
        this.date = date;
        this.noYear = noYear;
        this.eventTypeId = eventTypeId;
        this.title = title;
    }
}
