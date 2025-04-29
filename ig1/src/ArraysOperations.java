
//FOR EACH LOOP
public class ArraysOperations {
    public static void main(String[] args) {
        String[] names = new String[3];

        names[0] = "blue shirt";
        names[1] = "Red shirt";
        names[2] = "Black shirt";

        int [] numbers = { 100, 200, 300};

        for (String name:names){
            System.out.println("Name: " + name);
        }
        for (int number:numbers){
            System.out.println("Number: " + number);
        }
    }
}
