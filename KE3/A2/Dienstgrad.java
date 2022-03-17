package KE3.A2;

public enum Dienstgrad { 
  HELFER, TRUPPFUEHRER, GRUPPENFUEHRER, ZUGTRUPPFUEHRER, ZUGFUEHRER;

  public static void printAll() {
    for (Dienstgrad dienstgrad: values()){
      System.out.println(dienstgrad.toString());
    }
  }

  public String toString() {
    switch (this) {
      case ZUGFUEHRER:
        return "Zugfuehrer";
      case ZUGTRUPPFUEHRER:
        return "Zugtruppfuehrer";
      case GRUPPENFUEHRER:
        return "Gruppenfuehrer";
      case TRUPPFUEHRER:
        return "Truppfuehrer";
      default:
        return "Helfer";
    }
  }

  public boolean istVorgesetzterVor(Dienstgrad d) {
    return this.ordinal() > d.ordinal();
  }

  public static void main(String[] args){
    printAll();
    System.out.println(HELFER.istVorgesetzterVor(GRUPPENFUEHRER));
    System.out.println(TRUPPFUEHRER.istVorgesetzterVor(HELFER));
    System.out.println(GRUPPENFUEHRER.istVorgesetzterVor(GRUPPENFUEHRER));
  }


}