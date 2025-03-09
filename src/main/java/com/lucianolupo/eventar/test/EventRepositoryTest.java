package com.lucianolupo.eventar.test;

// import com.lucianolupo.eventar.models.Event;
// import com.lucianolupo.eventar.repository.EventRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import java.time.LocalDate;

// @Component
// public class EventRepositoryTest implements CommandLineRunner {

// private final EventRepository eventRepository;

// public EventRepositoryTest(EventRepository eventRepository) {
// this.eventRepository = eventRepository;
// }

// @Override
// public void run(String... args) {
// System.out.println("🔹 Running Event Repository Test...");

// // 1️⃣ Insert a new event
// Event event = new Event(LocalDate.of(2023, 12, 27), false, 1, "Test Event");
// eventRepository.save(event);
// System.out.println("✅ Inserted: " + event);

// // 2️⃣ Retrieve all events
// System.out.println("📌 Fetching all events:");
// eventRepository.findAll().forEach(System.out::println);
// }
// }
