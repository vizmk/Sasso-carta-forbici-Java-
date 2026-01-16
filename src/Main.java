import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Logic logic=new Logic();
        Scanner scanner=new Scanner(System.in);
        //leggiamo la scelt
        logic.test();
        String chose= scanner.next();

        logic.chose(chose);



    }
}