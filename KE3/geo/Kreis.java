package KE3.geo;
import KE3.geo.Geometrieobjekt;

public class Kreis extends Geometrieobjekt {

  private int radius;

  public Kreis() {
    this.radius = 4;
  }

  @Override
  public void druckeEigenschaften(){
    System.out.println("Radius: " + radius);
  } 
}