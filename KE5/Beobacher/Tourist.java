package KE5.Beobacher;
import KE5.Beobacher.Fahnenbeobachter;

// Der View

class Tourist implements Fahnenbeobachter {
  private String name = "Unbekannt";

  public Tourist(String name) {
    this.name = name;
  }

  public void fahnenstatusGeaendert(Fahnenmast fahnenmast){
    System.out.println(name + " vermeldet fuer den Fahnenmast: " 
      + fahnenmast.getFahnenposition());
  }
}