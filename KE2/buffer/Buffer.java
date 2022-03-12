package KE2.buffer;

public class Buffer {

  public Entry first;

  public Buffer(int size){

    first = new Entry();
    Entry lastInserted = first;
    
    for (int i = 0; i< size; i++){
      Entry newEntry = new Entry();
      newEntry.previous = lastInserted;
      lastInserted.next = newEntry;
      lastInserted = newEntry;
    }
    lastInserted.next = this.first;
    this.first.previous = lastInserted;
    
  }

  public void insert(String element){
    first = first.next;
    first.element = element;
  }

  public void print(){
    Entry current = first;
    do {
      System.out.println(current.element);
      current = current.previous;
    } 
    while (current != first);
  }

  private static class Entry {
    private String element;
    private Entry previous;
    private Entry next;
  }
}

