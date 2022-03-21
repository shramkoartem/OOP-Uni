package KE6.Aufgabe1;

import java.io.IOException;

public class Test extends Thread {

  private volatile boolean keepRunning = true;

  private boolean keepRunning(){
    return keepRunning;
  }

  private void stopRunning(){
    keepRunning = false;
  }


  @Override
  public void run() {
    while(keepRunning()){
      System.out.println("Hallo, ich komme.");
      try{
        Thread.sleep(500);
      } catch (InterruptedException e){
        System.out.println("Beim Schlafen unterbrochen.");
      }
      if(!keepRunning()){
        System.out.println("Ich gehe. Auf Wiedersehen!");
        //return;
        this.interrupt();
      }
    }
  }

  /* warten, bis die Enter-Taste gedrueckt wird */
  public void dotry() {
    try {
      System.in.read(); // Blockiert bis Zeile eingegeben
    } catch (IOException e){
      e.printStackTrace();
    }
    stopRunning();
  }
}