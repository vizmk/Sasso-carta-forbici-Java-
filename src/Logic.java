import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Logic {
    double random=0;
    String test;
    int rating=0;


    public void test(){
        random=Math.random();
        if(random<0.3333){
            test="paper";
        }else if((random>0.3333)&&(random<0.6666)){
            test="rock";
        }else if(random>0.6666){
            test="scissors";
        }
    }




    //verifica scelta
    public void chose(String chose){

        switch (chose) {
            case "paper":
                switch (test) {
                    case "paper" -> {
                        System.out.println("There is a draw " + test);
                        rating+=50;

                    }
                    case "rock" -> {
                        System.out.println("Well done. The computer chose " + test + " and failed");
                        rating+=100;

                    }
                    case "scissors" -> System.out.println("Sorry, but the computer chose " + test);

                }
                break;
            case "scissors":
                switch (test) {
                    case "scissors" -> {
                        System.out.println("There is a draw " + test);
                        rating+=50;
                    }

                    case "paper" -> {
                        System.out.println("Well done. The computer chose " + test + " and failed");
                        rating+=100;
                    }
                    case "rock" -> System.out.println("Sorry, but the computer chose " + test);
                }
                break;
            case "rock":
                switch (test) {
                    case "rock" -> {
                        System.out.println("There is a draw " + test);
                        rating+=50;
                    }
                    case "scissors" -> {
                        System.out.println("Well done. The computer chose " + test + " and failed");
                        rating+=100;
                    }

                    case "paper" -> System.out.println("Sorry, but the computer chose " + test);
                }
                break;

        }

    }

    //lettura file
    public void loadRating(String name) {
        try {
            File file = new File("rating.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                //conversione
                if(name.equals(parts[0])){
                    rating = Integer.parseInt(parts[1]);
                    return;


                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            rating = 0;
        }
    }




}