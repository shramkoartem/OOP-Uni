package KE5.Rechner;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.management.openmbean.OpenMBeanParameterInfo;

public class Rechner extends Frame {

  private BorderLayout borderLayout1 = new BorderLayout();
  private TextField eingabeFeld = new TextField("", 15);

  private Button[] ziffern = new Button[10];
  private Panel ziffernContainer = new Panel();

  private Button plus = new Button("+");
  private Button minus = new Button("-");
  private Button mal = new Button("*");
  private Button gleich = new Button("=");
  private Panel operatorContainer  = new Panel();

  private ZiffernListener ziffernListener = new ZiffernListener();
  private boolean starteNeueRechnung = true;

  /* Attributendeklaration fuer Berechnungen */
  private int operand1 = 0;
  private int operand2 = 0;
  private String operator_ = new String ("");

  public Rechner() {
    String ziffer;

    /* Layout fuer Frame festlegen */
    this.setLayout(borderLayout1);
    this.setSize(150,200);
    this.setLocation(100,100);
    this.setBackground(Color.gray);

    /* Flow Layout fuer Ziffern und Operatoren setzen */
    ziffernContainer.setLayout(new FlowLayout());
    operatorContainer.setLayout(new FlowLayout());
    

    /* Zifferntasten erzeugen und in Zifferpanel einfuegen */
    for (int i=0; i<10; i++){
      ziffer = String.valueOf(i);
      ziffern[i] = new Button(ziffer);
      ziffernContainer.add(ziffern[i]);
      ziffern[i].addActionListener(ziffernListener);
    }

    /* Operatorfarben in Operatorenpanel einfuegen */
    /* Vordergrungfarbe rot */
    plus.setForeground(Color.red);
    minus.setForeground(Color.red);
    mal.setForeground(Color.red);
    gleich.setForeground(Color.red);
    operatorContainer.add(plus);
    operatorContainer.add(minus);
    operatorContainer.add(mal);
    operatorContainer.add(gleich);

    // ActionListeners as anonymous classes!!!
    plus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        plus_actionPerformed(e);
      }
    });

    minus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        minus_actionPerformed(e);
      }
    });

    mal.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        mal_actionPerformed(e);
      }
    });

    gleich.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        gleich_actionPerformed(e);
      }
    });

    /* Attributendeklaration fuer Berechnungen */


    eingabeFeld.setBackground(Color.white);

    /* Objekte in Frame platzieren */
    this.add(eingabeFeld, BorderLayout.NORTH);
    this.add(ziffernContainer, BorderLayout.CENTER);
    this.add(operatorContainer, BorderLayout.SOUTH);
  
  }

  private void resetRechnung() {
    operator_ = "";
    operand1 = 0;
    operand2 = 0;
    starteNeueRechnung = true;
  }

  private void speichereOperand1 () {
    try {
      Integer operand = Integer.valueOf(eingabeFeld.getText());
      operand1 = operand.intValue();
    } 
    catch (NumberFormatException ex) {
      System.out.println(
        "Ungueltiger Integer fuer Operand1! Neue Eingabe"
      );
      resetRechnung();
    }
    eingabeFeld.setText("");
  }

  /* 
    * Bei korrekter Bearbeitungsreihenfolge
    * muss gueltiger Operator vorliegen
  */
  public boolean calculateResult(int op1, int op2, String operator_) {
    float floatResult = -1;
    boolean integerOverflow = false;
    int claculatedResult = -1;

    if (operator_.equals("+")){
      // Um etwaige Integerueberlauefe bei der Berechnung abzufangen
      floatResult = (float) op1 + (float) op2;
      claculatedResult = op1 + op2;
    } else if (operator_.equals("-")){
      floatResult = (float) op1 - (float) op2;
      claculatedResult = op1 - op2;
    } else if (operator_.equals("*")) {
      floatResult = (float) op1 * (float) op2;
      claculatedResult = op1 - op2;
    } 
    if ((floatResult > Integer.MAX_VALUE)
        || (floatResult < Integer.MIN_VALUE)){
          integerOverflow = true;
        }

    // *** Ergebnis pruefen und anzeigen ***
    if (!integerOverflow){
      eingabeFeld.setText(Integer.toString(claculatedResult));
    } else {
      eingabeFeld.setText("");
      System.out.println("Integerueberlauf beim Ergebnis!");
    }
    return (!integerOverflow);
  }

  private void plus_actionPerformed(ActionEvent e) {
    operator_ = "+";
    speichereOperand1();
  }
  private void minus_actionPerformed(ActionEvent e) {
      operator_ = "-";
      speichereOperand1();
  }
  private void mal_actionPerformed(ActionEvent e) {
      operator_ = "*";
      speichereOperand1();
  }

  private void gleich_actionPerformed(ActionEvent e) {
    Integer operand;
    try {
      operand = Integer.valueOf(eingabeFeld.getText());
      operand2 = operand.intValue();
      boolean result = calculateResult(operand1, operand2, operator_);
    } catch (NumberFormatException ex) {
      System.out.println("Ungueltiger Integer in Operand2!");
      eingabeFeld.setText("");
    }
    /* fuer neue Rechung initialisieren*/
    resetRechnung(); 
  }


  class ZiffernListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      Button sourceButton = (Button) e.getSource();
      int i = -1;
      boolean found;
      do {
        i++;
        found = (sourceButton == ziffern[i]);
      } while (!found);
      if (starteNeueRechnung){
        eingabeFeld.setText("");
        starteNeueRechnung = false;
      }
      eingabeFeld.setText(eingabeFeld.getText() + ziffern[i].getLabel());
    }
  }



  public static void main(String[] args){
    Rechner rechner = new Rechner();
    rechner.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    rechner.setVisible(true);
  }

}