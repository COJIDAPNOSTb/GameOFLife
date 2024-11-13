import java.io.IOException;
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



        // Метод для обычного игрового режима с разными скоростями
        public void gameNormal() throws IOException, InterruptedException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select speed: 1. Slow (2s), 2. Normal (1s), 3. Fast (0.5s)");


            long delay = 1000;

            String speedInput = scanner.nextLine();
            switch (speedInput) {
                case "1":
                    delay = 2000;
                    break;
                case "2":
                    delay = 1000;
                    break;
                case "3":
                    delay = 500;
                    break;
                default:
                    System.out.println("Unknown speed. Use Normmal mode as default.");
            }

            System.out.println("Conway's Game of Life: Normal Mode --- press 'q' to exit.");

            // Основной цикл игры
            while (true) {
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                grid.update();
                generation++;
                grid.display();
                System.out.println("Generation: " + generation);

                // Проверка на выход
                if (System.in.available() > 0) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("q")) {
                        System.out.println("Exiting..");
                        break;
                    }
                }

                // Задержка в зависимости от выбранной скорости
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
            scanner.close();
        }

        public static void main(String[] args) throws IOException, InterruptedException {
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
                game.gameNormal();
            } else {
                System.out.println("Unknown command.");
            }
            scanner.close();
        }
    }


