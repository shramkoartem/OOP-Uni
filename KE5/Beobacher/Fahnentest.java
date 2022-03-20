package KE5.Beobacher;


public class Fahnentest {
  public static void main(String[] args) {
    // model
    Fahnenmast meinFahnenmast = new Fahnenmast();

    // controllers
    Fahnenbedienung bedienung1 = new Fahnenbedienung(meinFahnenmast);
    Fahnenbedienung bedienung2 = new Fahnenbedienung(meinFahnenmast);

    // views
    Fahnenbeobachter anna = new Tourist("Anna");
    Fahnenbeobachter bernd = new Tourist("Bernd");
    Fahnenbeobachter charly = new Tourist("Charly");

    bedienung1.aendereBeflaggung(Fahnenposition.OBEN);

    meinFahnenmast.addFahnenbeobachter(bernd);

    Fahnenbeobachter michael = new Fahnenbeobachter() {
      public void fahnenstatusGeaendert(Fahnenmast fahnenmast){
        System.out.println("Ich bin der anonyme Beobachter Michael, und der status ist: " + fahnenmast.getFahnenposition());
      }
    };
    meinFahnenmast.addFahnenbeobachter(michael);
    meinFahnenmast.addFahnenbeobachter(mast -> System.out.println(
      "Sabine vermeldet fuer den Fahnenmast: " + mast.getFahnenposition()));


    bedienung1.aendereBeflaggung(Fahnenposition.HALBMAST);

    meinFahnenmast.addFahnenbeobachter(anna);
    meinFahnenmast.addFahnenbeobachter(charly);
    meinFahnenmast.removeFahnenbeobachter(bernd);

    bedienung2.aendereBeflaggung(Fahnenposition.UNBEFLAGGT);
    bedienung2.aendereBeflaggung(Fahnenposition.OBEN);

    meinFahnenmast.addFahnenbeobachter(bernd);
  }
}