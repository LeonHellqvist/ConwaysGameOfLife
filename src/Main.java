import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("######################");
        System.out.println("Hi and welcome to");
        System.out.println("Conways' Game Of Life");
        System.out.println("######################");
        Scanner input = new Scanner(System.in);
        System.out.print("Choose grid size (eg 16x16): ");
        String gridSize = input.nextLine();
        System.out.print("Choose starting positions (eg 1,0;1,1;1,2): ");
        String startingPositions = input.nextLine();

        Grid grid = new Grid(gridSize, startingPositions);
        while (true) {
            grid.printGrid();
            grid.nextGeneration();
            input.nextLine();
        }
    }
}