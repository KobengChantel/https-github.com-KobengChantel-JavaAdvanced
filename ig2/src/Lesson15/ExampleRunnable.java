package Lesson15;

public class ExampleRunnable implements Runnable{
    private final String name;
    public ExampleRunnable(String name){
        this.name = name;

    }
    @Override
    public void run(){
        //ptints name and number 1000 times
        for (int i = 0; i < 1000; i++){
            System.out.println(name + ":" + i);
        }
    }
}
