package KE2;

public class Summierer {

  public static void main(String[] args){

    Summierer summierer = new Summierer();

    int n = Integer.parseInt(args[0]);

    System.out.println("Ergebnis Kleiner Gauss: " + summierer.kleinerGauss(n));
    System.out.println("Ergebnis For Schleife: " + summierer.forSumme(n));
    System.out.println("Ergebnis Rekursiv: " + summierer.rekursiveSumme(n));
  }

  int kleinerGauss(int n){
    int summe = n*(n+1)/2;
    return summe;
  }

  int forSumme(int n){
    int summe = 0;

    for(int i=1; i<=n; i++){
      summe += i;
    }
    return summe;
  }

  // int rekursiveSumme(int n, int summe){
  //   // base case
  //   if (n == 0){
  //     return summe;
  //   }
  //   // rekursive
  //   summe += n;
  //   n--;
  //   return rekursiveSumme(n, summe);
  // }

  int rekursiveSumme(int n){
    //base case
    if (n<=0){
      return 0;    
    }
    return rekursiveSumme(n-1) + n;
  }



}