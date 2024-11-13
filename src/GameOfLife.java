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
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Выход из игры.");
                break;
            } else if (input.equalsIgnoreCase("n")) {
                grid.update();
                generation++;
                grid.display();
                System.out.println("Поколение: " + generation);
                System.out.println("Живых клеток: " + grid.countAliveCells());
                System.out.println("Мертвых клеток: " + grid.deadcells);
            } else {
                System.out.println("Неизвестная команда. Используйте 'n' для следующего поколения или 'q' для выхода.");
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
            System.out.println("Выход из игры.");
            System.exit(0);
        } else if (input.equalsIgnoreCase("d")) {
            game.gameDebug();
        } else if (input.equalsIgnoreCase("s")) {
            // Реализуйте основной игровой режим здесь, если требуется
        } else {
            System.out.println("Неизвестная команда.");
        }
        scanner.close();
    }
}
