import java.util.Random;

public class Grid {
    private final int SIZE = 25;
    private Cell[][] cells = new Cell[SIZE][SIZE];
    public int deadcells = 0;

    public Grid() {
        initializeGrid();
    }

    // Инициализация сетки с случайным состоянием клеток
    private void initializeGrid() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(false);
            }
            cells[5][6] = new Cell(true);
            cells[6][7] = new Cell(true);
            cells[6][8] = new Cell(true);
            cells[5][8] = new Cell(true);
            cells[4][8] = new Cell(true);

        }
    }
    // Обновление состояния сетки на следующий ход
    public void update() {
        Cell[][] newCells = new Cell[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                boolean currentState = cells[i][j].isAlive();

                // Применяем правила игры
                if (currentState && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    newCells[i][j] = new Cell(false);
                    deadcells++;

                } else if (!currentState && liveNeighbors == 3) {
                    newCells[i][j] = new Cell(true); // Клетка оживает
                } else {
                    newCells[i][j] = new Cell(currentState); // Сохраняет текущее состояние
                }
            }
        }
        cells = newCells;
    }

    // Подсчет живых соседей клетки
    private int countLiveNeighbors(int x, int y) {
        int liveCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nx = x + i;
                int ny = y + j;

                if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE && cells[nx][ny].isAlive()) {
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cells[i][j].isAlive() ? "X " : ". ");
            }
            System.out.println();
        }
    }
    public int countAliveCells() {
        int liveCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].isAlive()) {
                    liveCount++;
                }
            }
        }
        return liveCount;
    }


}
