package Lesson7;

// This test class demonstrates the difference between type-specific cache classes and a generic cache class by storing and retrieving Strings and Shirt objects.
public class TestCacheAny {

    public static void main(String args[]) {
        CacheString myMessage = new CacheString(); // Specific cache for String
        CacheShirt myShirt = new CacheShirt();     // Specific cache for Shirt

        // Generic caches that can handle any specified type
        CacheAny<String> myGenericMessage = new CacheAny<String>();
        CacheAny<Shirt> myGenericShirt = new CacheAny<Shirt>();

        // Add data and print from specific and generic caches
        myMessage.add("Save this for me");          // Using specific String cache (not printed here)
        myGenericMessage.add("Save this for me");   // Using generic cache with String
        System.out.println("Message is: " + myGenericMessage.get());

        myGenericShirt.add(Shirt.newShirt(1111, "Blue Shirt", "Blue", "Medium")); // Using generic cache with Shirt
        System.out.println("Shirt Type:" + myGenericShirt.get().toString());
    }
}
