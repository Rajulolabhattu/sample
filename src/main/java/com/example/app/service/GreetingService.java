package com.example.app.service;

import com.example.app.model.Greeting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service that manages greeting messages.
 */
public class GreetingService {
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private List<Greeting> greetings = new ArrayList<>();

    /**
     * Creates a new greeting with the given name.
     * 
     * @param name The name to include in the greeting
     * @return A new Greeting object
     */
    public Greeting createGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            name = "World";
        }
        
        String message = String.format(TEMPLATE, name);
        Greeting greeting = new Greeting(counter.incrementAndGet(), message);
        greetings.add(greeting);
        
        return greeting;
    }

    /**
     * Retrieves all greetings.
     * 
     * @return List of all greetings
     */
    public List<Greeting> getAllGreetings() {
        return new ArrayList<>(greetings);
    }

    /**
     * Finds a greeting by ID.
     * 
     * @param id The ID of the greeting to find
     * @return The greeting if found, or null otherwise
     */
    public Greeting findGreetingById(long id) {
        return greetings.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Deletes a greeting by ID.
     * 
     * @param id The ID of the greeting to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteGreeting(long id) {
        return greetings.removeIf(g -> g.getId() == id);
    }

    /**
     * Counts the number of greetings.
     * 
     * @return The count of greetings
     */
    public int getGreetingCount() {
        return greetings.size();
    }
}