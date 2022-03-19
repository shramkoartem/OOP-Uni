


public interface Iterator<T> {
  boolean hasNext();
  T getNext();
  void remove();
}

public interface Iterable<T> {
  Iterator<T> iterator();
}

public interface Comparable<T> {
  public int compareTo(T elem);
}