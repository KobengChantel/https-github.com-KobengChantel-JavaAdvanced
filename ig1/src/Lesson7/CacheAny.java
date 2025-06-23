package Lesson7;

//allows for any type to be passed into class
public class CacheAny<T>{
      
    private T t;
  
    public void add(T t){
        this.t = t;
    }
  
    public T get(){
        return this.t;
    }  
}
