public class Grid {
    char[][] grid;
    final int gridX;
    final int gridY;
    final char aliveChar = 'X';
    final char deadChar = '.';

    private boolean cellAlive(int y, int x) {
        return grid[y][x] == aliveChar;
    }

    private boolean shouldBeAlive(int y, int x) {
        int aliveNeighbors = 0;
        // If cell has neighbor above left
        if (y - 1 >= 0 && x - 1 >= 0) {
            if (cellAlive(y-1, x-1)) {aliveNeighbors++;}
        }
        // If cell has neighbor above
        if (y - 1 >= 0) {
            if (cellAlive(y-1, x)) {aliveNeighbors++;}
        }
        // If cell has neighbor above right
        if (y - 1 >= 0 && x + 1 < gridX) {
            if (cellAlive(y-1, x+1)) {aliveNeighbors++;}
        }
        // If cell has neighbor right
        if (x + 1 < gridX) {
            if (cellAlive(y, x+1)) {aliveNeighbors++;}
        }
        // If cell has neighbor under right
        if (y + 1 < gridY && x + 1 < gridX) {
            if (cellAlive(y+1, x+1)) {aliveNeighbors++;}
        }
        // If cell has neighbor under
        if (y + 1 < gridY) {
            if (cellAlive(y+1, x)) {aliveNeighbors++;}
        }
        // If cell has neighbor under left
        if (y + 1 < gridY && x - 1 >= 0) {
            if (cellAlive(y+1, x-1)) {aliveNeighbors++;}
        }
        // If cell has neighbor left
        if (x - 1 >= 0) {
            if (cellAlive(y, x-1)) {aliveNeighbors++;}
        }
        // Handles dead cell
        if (!cellAlive(y, x)) {
            return aliveNeighbors == 3;
        }
        // Handles alive cell
        else {
            if (aliveNeighbors <= 1) {
                return false;
            }
            return aliveNeighbors < 4;
        }
    }

    public Grid(String gridSize, String startingPositions) {
        int gridSizeY = Integer.parseInt(gridSize.split("x")[0]);
        int gridSizeX = Integer.parseInt(gridSize.split("x")[1]);
        char[][] gridBuild = new char[gridSizeY][gridSizeX];
        // Loop over grid to set default values
        for (int y = 0; y < gridSizeY; y++) {
            for (int x = 0; x < gridSizeX; x++) {
                gridBuild[y][x] = deadChar;
            }
        }

        String[] startingPositionsList = startingPositions.split(";");
        for (String s : startingPositionsList) {
            int posX = Integer.parseInt(s.split(",")[0]);
            int posY = Integer.parseInt(s.split(",")[1]);
            gridBuild[posY][posX] = aliveChar;
        }
        grid = gridBuild;
        gridX = gridSizeX;
        gridY = gridSizeY;
    }

    public void nextGeneration() {
        char[][] newGrid = new char[gridY][gridX];
        for (int y = 0; y < gridY; y++) {
            System.arraycopy(grid[y], 0, newGrid[y], 0, gridX);
        }

        for (int y = 0; y < gridY; y++) {
            for (int x = 0; x < gridX; x++) {
                if (shouldBeAlive(y, x)) {
                    newGrid[y][x] = aliveChar;

                } else {

                    newGrid[y][x] = deadChar;

                }
            }
        }
        for (int y = 0; y < gridY; y++) {
            System.arraycopy(newGrid[y], 0, grid[y], 0, gridX);
        }

    }

    public void printGrid() {
        for (int y = 0; y < gridY; y++) {
            for (int x = 0; x < gridX; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.print("\n");
        }
    }

}
