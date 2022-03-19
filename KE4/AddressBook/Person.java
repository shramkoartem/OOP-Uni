package KE4.AddressBook;

import java.io.Serializable;

class Person implements Serializable{
  private String name;

  public Person(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  
}