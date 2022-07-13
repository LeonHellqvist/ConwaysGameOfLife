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
        System.out.print("Choose grid size (eg 25x40): ");
        String gridSize = input.nextLine();
        System.out.print("Choose starting positions (eg 5,5;5,6;4,6;6,6 (x, y): ");
        String startingPositions = input.nextLine();

        Grid grid = new Grid(gridSize, startingPositions);
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            grid.printGrid();
            grid.nextGeneration();
            try {
                Thread.sleep(300);
            }
            catch(Exception e) {
                System.out.println("Time.sleep exception");
            }
        }
    }
}