package KE1;

public class GameOfLife {
  boolean[][] field;
  float prob;

  public GameOfLife(int n, float prob){
    field = new boolean[n][n]; 

    for (int i=0; i<n; i++){
      for (int j=0; j<n; j++){
        field[i][j] = Math.random() < prob;
      }
    }
  }

  void print(){
    for (int i=0; i<field.length; i++){
      for (int j=0; j<field.length; j++){
        if( field[i][j]){
          System.out.print("o ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
  }

  void nextGeneration(){
    boolean[][] newField = new boolean[field.length][field.length];

    for (int i=1; i<field.length-1; i++){
      for (int j=1; j<field.length -1; j++){
        // Count the number of living cells including current
        int neighbours = 0;
        for (int k=i-1; k<=i+1; k++){
          for (int l=j-1; l<= j+1; l++){
            if (field[k][l]) neighbours++;
          }
        }
        // Living cells with 2-3 neighbours live on
        if (field[i][j] & (neighbours == 2 || neighbours ==3)){
          newField[i][j] = true;
        } else {
          // revoke dead cells with exactly 3 neighbours
          if (!field[i][j] && neighbours == 3){
            newField[i][j] = true;
          }
        }

      }
    }
    field = newField;
  }

  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    float prob = Float.parseFloat(args[1]);

    GameOfLife game = new GameOfLife(n, prob);
    for (int i=0; i<10; i++){
      System.out.println("Generation: "+i);
      game.print();
      game.nextGeneration();
      System.out.println();
    }

  }


}