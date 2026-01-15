public class Logic {

    //verifica scelta
    public void chose(String chose){
        switch (chose) {
            case "paper" -> System.out.println("Sorry, but the computer chose scissors.");
            case "scissors" -> System.out.println("Sorry, but the computer chose rock.");
            case "rock" -> System.out.println("Sorry, but the computer chose paper.");
        }
    }


}