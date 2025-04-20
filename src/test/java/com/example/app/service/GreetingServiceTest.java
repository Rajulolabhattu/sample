package com.example.app.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.app.model.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test class for GreetingService.
 */
public class GreetingServiceTest {
    
    private GreetingService greetingService;
    
    @BeforeEach
    public void setUp() {
        greetingService = new GreetingService();
    }
    
    @Test
    @DisplayName("Test creating a greeting with a name")
    public void testCreateGreetingWithName() {
        // Arrange
        String name = "John";
        
        // Act
        Greeting greeting = greetingService.createGreeting(name);
        
        // Assert
        assertNotNull(greeting, "Greeting should not be null");
        assertEquals("Hello, John!", greeting.getMessage(), "Message should contain the provided name");
        assertEquals(1, greeting.getId(), "First greeting should have ID 1");
    }
    
    @Test
    @DisplayName("Test creating a greeting with null name")
    public void testCreateGreetingWithNullName() {
        // Act
        Greeting greeting = greetingService.createGreeting(null);
        
        // Assert
        assertNotNull(greeting, "Greeting should not be null");
        assertEquals("Hello, World!", greeting.getMessage(), "Message should use default name");
    }
    
    @Test
    @DisplayName("Test creating a greeting with empty name")
    public void testCreateGreetingWithEmptyName() {
        // Act
        Greeting greeting = greetingService.createGreeting("");
        
        // Assert
        assertNotNull(greeting, "Greeting should not be null");
        assertEquals("Hello, World!", greeting.getMessage(), "Message should use default name");
    }
    
    @Test
    @DisplayName("Test getting all greetings")
    public void testGetAllGreetings() {
        // Arrange
        greetingService.createGreeting("John");
        greetingService.createGreeting("Jane");
        
        // Act
        List<Greeting> greetings = greetingService.getAllGreetings();
        
        // Assert
        assertEquals(2, greetings.size(), "Should return 2 greetings");
        assertEquals("Hello, John!", greetings.get(0).getMessage(), "First greeting should be for John");
        assertEquals("Hello, Jane!", greetings.get(1).getMessage(), "Second greeting should be for Jane");
    }
    
    @Test
    @DisplayName("Test finding a greeting by ID")
    public void testFindGreetingById() {
        // Arrange
        greetingService.createGreeting("John");
        Greeting secondGreeting = greetingService.createGreeting("Jane");
        
        // Act
        Greeting found = greetingService.findGreetingById(secondGreeting.getId());
        
        // Assert
        assertNotNull(found, "Should find the greeting");
        assertEquals(secondGreeting.getId(), found.getId(), "IDs should match");
        assertEquals(secondGreeting.getMessage(), found.getMessage(), "Messages should match");
    }
    
    @Test
    @DisplayName("Test finding a non-existent greeting")
    public void testFindNonExistentGreeting() {
        // Arrange
        greetingService.createGreeting("John");
        
        // Act
        Greeting found = greetingService.findGreetingById(999);
        
        // Assert
        assertNull(found, "Should return null for non-existent ID");
    }
    
    @Test
    @DisplayName("Test deleting a greeting")
    public void testDeleteGreeting() {
        // Arrange
        Greeting greeting = greetingService.createGreeting("John");
        
        // Act
        boolean deleted = greetingService.deleteGreeting(greeting.getId());
        
        // Assert
        assertTrue(deleted, "Delete should return true");
        assertEquals(0, greetingService.getGreetingCount(), "Greeting count should be 0");
        assertNull(greetingService.findGreetingById(greeting.getId()), "Greeting should not be found after deletion");
    }
    
    @Test
    @DisplayName("Test deleting a non-existent greeting")
    public void testDeleteNonExistentGreeting() {
        // Act
        boolean deleted = greetingService.deleteGreeting(999);
        
        // Assert
        assertFalse(deleted, "Delete should return false for non-existent ID");
    }
    
    @Test
    @DisplayName("Test getting greeting count")
    public void testGetGreetingCount() {
        // Arrange
        assertEquals(0, greetingService.getGreetingCount(), "Initial count should be 0");
        
        // Act
        greetingService.createGreeting("John");
        greetingService.createGreeting("Jane");
        
        // Assert
        assertEquals(2, greetingService.getGreetingCount(), "Count should be 2 after adding greetings");
        
        // Act
        greetingService.deleteGreeting(1);
        
        // Assert
        assertEquals(1, greetingService.getGreetingCount(), "Count should be 1 after deleting a greeting");
    }
}