package Lesson7;

// A class that stores and retrieves a Shirt object, providing type-specific caching without using generics.
public class CacheShirt {
    private Shirt shirt; // Variable to hold a Shirt object

    // Stores the given Shirt object in the cache
    public void add(Shirt shirt) {
        this.shirt = shirt;
    }

    // Retrieves the stored Shirt object from the cache
    public Shirt get() {
        return this.shirt;
    }
}
