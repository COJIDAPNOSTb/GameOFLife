import java.util.Scanner;
public class GameOfLife {
    private Grid grid;
    private int generation;

    public GameOfLife() {
        this.grid = new Grid();
        this.generation = 0;
    }

    public void gameDebug() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Conway's Game of Life: Debug Mode --- press 'n' for next generation or 'q' for exit.");
        grid.display();

        while (true) {
            System.out.print("Input command ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting..");
                break;
            } else if (input.equalsIgnoreCase("n")) {
                grid.update();
                generation++;
                grid.display();
                System.out.println("Generation: " + generation);
                System.out.println("Alive cells:" + grid.countAliveCells());
                System.out.println("Dead cells:" + grid.deadcells);
            } else {
                System.out.println("Unknown command. Use 'n' for next generation or 'q' for exit.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        System.out.println("Conway's Game of Life: press 'd' for debug mode, 's' for start or 'q' for exit.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("q")) {
            System.out.println("Exiting..");
            System.exit(0);
        } else if (input.equalsIgnoreCase("d")) {
            game.gameDebug();
        } else if (input.equalsIgnoreCase("s")) {

        } else {
            System.out.println("Unknown command.");
        }
        scanner.close();
    }
}
