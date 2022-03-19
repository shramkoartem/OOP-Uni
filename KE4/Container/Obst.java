package KE4.Container;

public abstract class Obst implements Comparable<Obst> {
  private int gewicht;
  public String name;

  public Obst(int g) {
    this.gewicht = g;
  }

  @Override
  public int compareTo(Obst obst){
    return this.gewicht - obst.gewicht;
  }

  public void getGewicht(){
    System.out.println(name + " : " + gewicht);
  }

}