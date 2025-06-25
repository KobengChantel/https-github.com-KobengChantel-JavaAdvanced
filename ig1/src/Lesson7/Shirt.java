package Lesson7;

// A Shirt class with private fields and a private constructor, using a static factory method to create Shirt instances and overriding toString for detailed info output.
public class Shirt {

    private int shirtID = 0;
    private String description = "";
    private String color = "";
    private String size = "";
    private StringBuilder sb = new StringBuilder(128);

    // Private constructor to force use of static factory method
    private Shirt() { }

    // Static factory method to create a new Shirt instance with given properties
    public static Shirt newShirt(int id, String description, String color, String size) {
        Shirt newShirt = new Shirt();
        newShirt.setId(id);
        newShirt.setDescription(description);
        newShirt.setColor(color);
        newShirt.setSize(size);

        return newShirt;
    }

    public int getId() {
        return this.shirtID;
    }

    public void setId(int id) {
        this.shirtID = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Returns a formatted string describing the Shirt's properties
    public String toString() {
        sb.setLength(0); // Clear StringBuilder before reuse
        sb.append("Shirt ID: ").append(this.getId()).append("\n");
        sb.append("Description: ").append(this.getDescription()).append("\n");
        sb.append("Color: ").append(this.getColor()).append("\n");
        sb.append("Size: ").append(this.getSize()).append("\n");

        return sb.toString();
    }
}
