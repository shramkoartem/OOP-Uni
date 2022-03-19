package KE4.Container;
import java.util.function.BiFunction;

import KE4.Container.Apfel;
import KE4.Container.Birne;
import KE4.Container.Obst;
import KE4.Container.MaximumContainer;

public class ContainerTest {
  public static void main(String[] args){
    MaximumContainer<Obst> cont = new MaximumContainer<Obst>();
    Apfel a1 = new Apfel(10);
    Birne b1 = new Birne(12);
    Apfel a2 = new Apfel(15);
    Birne b2 = new Birne(8);

    cont.store(a1);
    cont.get().getGewicht();
    cont.store(b1);
    cont.get().getGewicht();
    cont.store(a2);
    cont.get().getGewicht();
    cont.store(b2);
    cont.get().getGewicht();   
  }
}