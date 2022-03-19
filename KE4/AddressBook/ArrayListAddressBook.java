package KE4.AddressBook;
import java.util.ArrayList;

public class ArrayListAddressBook implements AddressBook {
  private ArrayList<Person> persons;

  public ArrayListAddressBook(int initialCapacity) {
    initialCapacity = initialCapacity < 1 ? 1 : initialCapacity;
    persons = new ArrayList<Person>(initialCapacity);
  }

  @Override
  public void addPerson(Person person){
    persons.add(person);
  }

  @Override
  public void print(){
    for (Person person: persons){
      System.out.println(person.getName());

    }
  }
}