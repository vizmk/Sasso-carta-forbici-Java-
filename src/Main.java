import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Logic logic=new Logic();
        Scanner scanner=new Scanner(System.in);
        boolean exit=false;
        //start cicle

        do{
            logic.test();
            String chose = scanner.next();
            if((chose.equals("paper")||(chose.equals("rock"))||(chose.equals("scissors"))||(chose.equals("!exit")))) {

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