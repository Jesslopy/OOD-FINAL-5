import java.util.Scanner;

public class TowerConquestGame {
    private GameState gameState;
    private Character playerCharacter;

    public TowerConquestGame() {
        gameState = new GameState();
        initializeGameElements();
    }

    private void initializeGameElements() {
        // Create characters
        Character hero = new Character("Hero", 100, 10);
        Character villain = new Character("Villain", 100, 15);

        // Add characters to GameState
        gameState.addCharacter(hero);
        gameState.addCharacter(villain);

        // Initialize player character
        playerCharacter = new Character("Player", 100, 10);
        gameState.addCharacter(playerCharacter);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Tower Conquest!");
        System.out.println("Available commands:");
        System.out.println("- name [character name]: Set your character's name");
        System.out.println("- choose [strategy]: Choose your starting strategy");
        System.out.println("- rules: Show game rules");
        System.out.println("- trigger event: Trigger a random event");
        System.out.println("- show status: Display current game status");
        System.out.println("- exit: Exit the game");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            // Command processing
            if (command.toLowerCase().startsWith("name ")) {
                String name = command.substring(5).trim();
                playerCharacter.setName(name);
                System.out.println("Character name set to: " + name);
            } else if (command.toLowerCase().startsWith("choose ")) {
                String strategyName = command.substring(7).trim();
                // Implement strategy selection logic here
                System.out.println("Strategy chosen: " + strategyName);
            } else if (command.equalsIgnoreCase("rules")) {
                // Display game rules
                System.out.println("Game rules...");
            } else if (command.equalsIgnoreCase("trigger event")) {
                gameState.triggerRandomEvent();
            } else if (command.equalsIgnoreCase("show status")) {
                gameState.displayStatus();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game...");
                break;
            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TowerConquestGame game = new TowerConquestGame();
        game.startGame();
    }
}

