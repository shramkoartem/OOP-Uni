package KE1;

class GeometrieProgramm {

  public static void main(String[] args){
    if (args.length == 0){
      System.out.println("Give input");
      return;
    }
    String figName = args[0].toLowerCase();
    System.out.println("Your input is: " + figName);

    switch(figName){
      case "square":
        System.out.println("4 corners");
        System.out.println("4 symmetry axes");
        System.out.println("Is enclosed");
        break;
      case "triangle":
        System.out.println("3 corners");
        System.out.println("3 symmetry axes");
        System.out.println("Is enclosed");
        break;
      default:
        System.out.println("Figure is unknown.");
    }
   return; 
  }
}