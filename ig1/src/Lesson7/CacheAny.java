package Lesson7;

// A generic class that can store and retrieve an object of any specified type T.
public class CacheAny<T> {

    private T t; // Variable to hold an object of type T

    // Stores the given object of type T in the cache
    public void add(T t) {
        this.t = t;
    }

    // Retrieves the stored object of type T from the cache
    public T get() {
        return this.t;
    }
}
