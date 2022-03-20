package KE5.Beobacher;

// Controller
class Fahnenbedienung {
  private Fahnenmast fahnenmast;

  public Fahnenbedienung(Fahnenmast fahnenmast) {
    this.fahnenmast = fahnenmast;
  }

  public void aendereBeflaggung(Fahnenposition fahnenposition) {
    fahnenmast.setStatus(fahnenposition);
  }
}