package Lesson4;

public class TestImmutable {
    //immutable classes can't be changed or extended
    public static void main(String[] args) {
        Contacts c = new Contacts("Jada", "Mathele");
        System.out.println(c);
    }
}
