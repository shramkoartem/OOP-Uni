package KE1;

class ZahlAusdenken {

  public static void main(String[] args){

    if (args.length == 0){
      System.out.println("Bitte geben Sie ein Zahl ein!");
      return;
    }
    int startZahl;
    try {
      startZahl = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      System.out.println("Eingabe muss eine ganze Zahl werden!");
      return;
    }
    int ergebnis = startZahl;

    // Step 1: increase input by 2
    // if input is negative -> invert to positive
    if (ergebnis>0){
      ergebnis = ergebnis + 2;
    } else {
      ergebnis = ergebnis * (-1) + 2;
    }

    // The result will be 0 for even and 1 for odd numbers
    while (ergebnis > 2){
      ergebnis = ergebnis - 2;
    }

    // Increase 'arbeiten' 10 times by the start number
    int arbeiten = 4;
    for (int i=2; i <= 20; i=i+2){
      arbeiten = arbeiten + startZahl;
    }

    switch (ergebnis) {
      case 0:
        System.out.println("Das kann nicht sein!");
        break;
      case 1:
        System.out.println("Die urspruengliche Zahl war ungerade!");
        break;
      case 2:
        System.out.println("Die urspruengliche Zahl war gerade!");
        break;
      default:
        System.out.println("Fehler!");
    }
    System.out.println("startzahl = " + startZahl);

  }
}