package Lesson4.ex04_3_exercise;

// This class implements the Singleton pattern to provide a single shared instance containing a fixed list of host names.

public final class PeerSingleton {

    private static final String[] hostNames = new String[5]; // Static array to store host names

    // Static initializer block – executes when class is first loaded
    static {
        // Normally, this might read from a file – here we hardcode the values
        hostNames[0] = "192.168.1.2";
        hostNames[1] = "192.168.1.4";
        hostNames[2] = "192.168.2.3";
        hostNames[3] = "192.168.2.5";
        hostNames[4] = "192.168.2.14";
    }

    // Private static instance of the class (eager initialization)
    private static final PeerSingleton instance = new PeerSingleton();

    // Public constructor (optional but not recommended in a strict singleton)
    public PeerSingleton() {
    }

    // Public method to return the hostNames array
    public String[] getHostNames() {
        return hostNames;
    }

    // Public static method to provide global access to the singleton instance
    public static PeerSingleton getInstance() {
        return instance;
    }
}
