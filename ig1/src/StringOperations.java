public class StringOperations {
    public static void main(String[] args) {
        //StringBuilder class is used when dealing with large dtrings or modifying the contents of a string often

        StringBuilder sb = new StringBuilder("hello");
        System.out.println("string sb: " + sb);
        sb.append("world");
        System.out.println("string sb: " + sb);

        sb.append("!").append("are").append("you");
        System.out.println("string sb: " + sb);

        sb.insert(12, "How");
        System.out.println("string sb: " + sb);

        //Get length
        System.out.println("Length: " + sb.length());

        //Get SubString
        System.out.println("Sub: " + sb.substring(0, 5));
    }
}
