package KE4.AddressBook;
import KE4.AddressBook.AddressBookException;

interface FullPersistance {
  AddressBook loadBook(String name) throws AddressBookException;

  void storeBook(AddressBook book, String name) throws AddressBookException;

}