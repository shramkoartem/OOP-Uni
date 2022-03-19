package KE4.Container;
import KE4.Container.Comparable;

public class MaximumContainer<T extends Comparable<T>> {

  private T elem;

  public T get(){
    return elem;
  }

  public void store(T e){
    if(elem == null || elem.compareTo(e)<0){
      this.elem = e;
    }
  }
  
}