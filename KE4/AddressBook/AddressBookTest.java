package KE4.AddressBook;
import KE4.AddressBook.*;

public class AddressBookTest {
  public static void main(String[] args){
    AddressBook book1  = new ArrayListAddressBook(2);
    book1.addPerson(new Person("Michael"));
    book1.addPerson(new Person("Lara"));
    book1.addPerson(new Person("Daniela"));
    book1.addPerson(new Person("Martin"));
    book1.addPerson(new Person("Donald"));
    book1.print();

    FullPersistance fp = new SerializationToFilePersistence();
    try { 
      fp.storeBook(book1, "first");
    } catch (AddressBookException e) {
      System.out.println("Error: Couldn't store addressbook.");
      e.printStackTrace();
      System.exit(0);
    }

    System.out.println("-----------------------------------------");

    try {
      AddressBook book2 = fp.loadBook("first");
      book2.print();
    } catch (AddressBookException e) {
      System.out.println("Error: Couldn't read addressbook.");
      e.printStackTrace();
      System.exit(0);
    }
  }
}
