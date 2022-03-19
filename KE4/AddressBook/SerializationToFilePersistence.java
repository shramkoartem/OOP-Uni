package KE4.AddressBook;
import KE4.AddressBook.FullPersistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import KE4.AddressBook.AddressBookException;


public class SerializationToFilePersistence implements FullPersistance { 

  @Override
  public AddressBook loadBook(String name) throws AddressBookException {
    ObjectInputStream ois = null;

    try {
      ois = new ObjectInputStream(new FileInputStream(name));
      return (AddressBook) ois.readObject();

    } catch (IOException e){
      throw new AddressBookException(e.getMessage());
    } catch (ClassNotFoundException e) {
      throw new AddressBookException(e.getMessage());
    } finally {
      try {
        if (ois != null) {
          ois.close();
      }} catch (IOException e){
        e.printStackTrace();
      }

    }
  }

  @Override
  public void storeBook(AddressBook book, String name) {
    ObjectOutputStream oos = null;

    try {
      oos = new ObjectOutputStream(new FileOutputStream(name));
      oos.writeObject(book);
    } catch (IOException e){
      //throw new AddressBookException(e.getMessage());
    } finally {
      if (oos != null) {
        try {
          oos.flush();
          oos.close();
        } catch (IOException e){
          e.printStackTrace();
        }
      }

    }
  }


}
