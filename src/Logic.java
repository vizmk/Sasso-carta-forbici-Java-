public class Logic {
    double random=0;
    String test;


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
                    case "paper" -> System.out.println("There is a draw " + test);
                    case "rock" -> System.out.println("Well done. The computer chose " + test + " and failed");
                    case "scissors" -> System.out.println("Sorry, but the computer chose " + test);
                }
                break;
            case "scissors":
                switch (test) {
                    case "scissors" -> System.out.println("There is a draw " + test);
                    case "paper" -> System.out.println("Well done. The computer chose " + test + " and failed");
                    case "rock" -> System.out.println("Sorry, but the computer chose " + test);
                }
                break;
            case "rock":
                switch (test) {
                    case "rock" -> System.out.println("There is a draw " + test);
                    case "scissors" ->
                            System.out.println("Well done. The computer chose " + test + " and failed");
                    case "paper" -> System.out.println("Sorry, but the computer chose " + test);
                }
                break;

        }

    }
}