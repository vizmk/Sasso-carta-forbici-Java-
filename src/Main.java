void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your name: ");
    String name = scanner.nextLine().trim();
    System.out.println("Hello, " + name);

    Logic logic = new Logic();
    logic.loadRating(name);

    // Options line (can be empty)
    String optionsLine = scanner.nextLine().trim();
    if (optionsLine.isEmpty()) {
        logic.setOptionsDefault();
    } else {
        logic.setOptionsFromLine(optionsLine);
    }

    System.out.println("Okay, let's start");

    while (true) {
        String input = scanner.nextLine().trim();

        if (input.equals("!exit")) {
            System.out.println("Bye!");
            break;
        }

        if (input.equals("!rating")) {
            System.out.println("Your rating: " + logic.getRating());
            continue;
        }

        if (!logic.isValidOption(input)) {
            System.out.println("Invalid input");
            continue;
        }

        String computer = logic.randomComputerChoice();
        Logic.Outcome outcome = logic.evaluate(input, computer);

        switch (outcome) {
            case DRAW -> {
                System.out.println("There is a draw (" + computer + ")");
                logic.addDrawPoints();
            }
            case WIN -> {
                System.out.println("Well done. The computer chose " + computer + " and failed");
                logic.addWinPoints();
            }
            case LOSE -> System.out.println("Sorry, but the computer chose " + computer);
        }
    }
}
