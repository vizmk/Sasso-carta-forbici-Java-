import java.util.Scanner;

public static void main(String[] args){
    Logic logic=new Logic();
    Scanner scanner=new Scanner(System.in);
    boolean exit=false;

    System.out.print("Enter your name: ");
    String name= scanner.next();
    logic.loadRating(name);
    System.out.println("Hello, "+name);
    //start cicle

    do{
        logic.test();
        String chose = scanner.next();
        if((chose.equals("paper")||(chose.equals("rock"))||(chose.equals("scissors"))||(chose.equals("!exit")))||(chose.equals("!rating"))) {
            if(chose.equals("!rating")){
                System.out.println("Your rating: "+logic.rating);
            }
            if (chose.equals("!exit")) {
                exit = true;
            }

            logic.chose(chose);
        }else {
            System.out.println("Invalid input");
        }
    }while(!exit);


}
}