package Lesson15;

import java.util.concurrent.Callable;

/***
 *
 * @author tmcginn
 */

public class ExampleCallable {

    private final String name;
    private final int len;
    private int sum = 0;

    public ExampleCallable(String name, int len){
        this.name = name;
        this.len = len;
    }

    @Override
    public String call() throws Exception{
        //prints length per name
        for( int i = 0; i < len; i++){
            System.out.println(name + ":" + i);
            sum += i;
        }
        return "sum: " + sum;
    }

}
