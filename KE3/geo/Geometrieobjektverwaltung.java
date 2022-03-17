package KE3.geo;
import KE3.geo.Geometrieobjekt;
import KE3.geo.Kreis;
import KE3.geo.Bogenstueck;
import KE3.geo.Rechteck;

public class Geometrieobjektverwaltung {
  public static void main(String[] args) {
    Geometrieobjekt geometrieobjekt = null;

    if (args[0].equals("Kreis")){
      geometrieobjekt = new Kreis();
    if (args[0].equals("Bogenstueck")){
      geometrieobjekt = new Bogenstueck();
    if (args[0].equals("Recheck")) {
      geometrieobjekt = new Rechteck();
    }
    if (geometrieobjekt == null) {
      System.out.println("Ein " + args[0] + " ist bisher nicht implementiert");
    } else {
      geometrieobjekt.druckeEigenschaften();
    }
    }
    }
  }
}
