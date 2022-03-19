package KE4.AddressBook;
import java.io.Serializable;

public interface AddressBook extends Serializable {
  void addPerson(Person person);

  void print();
}
