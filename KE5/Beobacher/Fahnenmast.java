package KE5.Beobacher;
import KE5.Beobacher.Fahnenposition;

import java.util.ArrayList;

// Model-View-Controller pattern
// This is Model

public class Fahnenmast {

  private Fahnenposition fahnenposition = Fahnenposition.UNBEFLAGGT;
  
  private ArrayList<Fahnenbeobachter> beobachterListe = new ArrayList<Fahnenbeobachter>();

  public void addFahnenbeobachter(Fahnenbeobachter neuerbeobachter){
    beobachterListe.add(neuerbeobachter);
  }

  public void removeFahnenbeobachter(Fahnenbeobachter neuerbeobachter){
    beobachterListe.remove(neuerbeobachter);
  }

  public void setStatus(Fahnenposition fahnenposition){
    this.fahnenposition = fahnenposition;

    for (Fahnenbeobachter fb: beobachterListe){
      // call method
      fb.fahnenstatusGeaendert(this);
    }
  }

  public Fahnenposition getFahnenposition() {
    //
    return fahnenposition;
  }

}