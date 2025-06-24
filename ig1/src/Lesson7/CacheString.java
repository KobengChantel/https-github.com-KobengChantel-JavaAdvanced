package Lesson7;

// A class designed to store and retrieve a String message, acting as a simple string cache.
public class CacheString {

    private String message; // Variable to hold the cached String

    // Stores the given String message in the cache
    public void add(String message) {
        this.message = message;
    }

    // Retrieves the stored String message from the cache
    public String get() {
        return this.message;
    }
}
