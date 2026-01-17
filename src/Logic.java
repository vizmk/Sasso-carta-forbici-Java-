import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Logic {

    public enum Outcome { WIN, LOSE, DRAW }

    private final Random random = new Random();

    private List<String> options = new ArrayList<>();
    private final Set<String> optionsSet = new HashSet<>();

    private int rating = 0;

    public int getRating() {
        return rating;
    }

    public void addWinPoints() {
        rating += 100;
    }

    public void addDrawPoints() {
        rating += 50;
    }

    public void setOptionsDefault() {
        options = new ArrayList<>(List.of("rock", "paper", "scissors"));
        rebuildSet();
    }

    public void setOptionsFromLine(String line) {
        String[] parts = line.split(",");
        options = new ArrayList<>();
        for (String p : parts) {
            String opt = p.trim();
            if (!opt.isEmpty()) {
                options.add(opt);
            }
        }
        // fallback safety (shouldn't happen in tests)
        if (options.isEmpty()) {
            setOptionsDefault();
            return;
        }
        rebuildSet();
    }

    private void rebuildSet() {
        optionsSet.clear();
        optionsSet.addAll(options);
    }

    public boolean isValidOption(String userChoice) {
        return optionsSet.contains(userChoice);
    }

    public String randomComputerChoice() {
        return options.get(random.nextInt(options.size()));
    }

    public Outcome evaluate(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return Outcome.DRAW;
        }

        int n = options.size();
        int userIndex = options.indexOf(userChoice);

        // Build rotated list excluding user's choice:
        // start from element right after user's, wrap around, collect n-1 elements
        List<String> rotated = new ArrayList<>(n - 1);
        for (int step = 1; step < n; step++) {
            rotated.add(options.get((userIndex + step) % n));
        }

        int half = (n - 1) / 2;

        // First half beats user (user loses)
        List<String> beatsUser = rotated.subList(0, half);

        if (beatsUser.contains(computerChoice)) {
            return Outcome.LOSE;
        } else {
            return Outcome.WIN;
        }
    }

    public void loadRating(String name) {
        rating = 0;

        try (Scanner scanner = new Scanner(new File("rating.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 2) continue;

                String fileName = parts[0];
                String fileScore = parts[1];

                if (fileName.equals(name)) {
                    rating = Integer.parseInt(fileScore);
                    return;
                }
            }
        } catch (FileNotFoundException ignored) {
            // If file doesn't exist, start from 0 (as required)
            rating = 0;
        }
    }
}
