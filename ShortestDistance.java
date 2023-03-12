import java.util.*;

public class ShortestDistance {
    
    // Method to calculate the Euclidean distance between two points
    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    public static void main(String[] args) {
        // Initializing the grid
        int[][] grid = new int[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                grid[i][j] = i * 11 + j;
            }
        }
        
        // Getting the start point and path from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start point coordinates in the format [x, y]: ");
        int[] startPoint = Arrays.stream(scanner.nextLine().replaceAll("\\[|\\]|\\s", "").split(","))
                                  .mapToInt(Integer::parseInt).toArray();
        System.out.print("Enter path: ");
        String path = scanner.nextLine().toUpperCase();
        scanner.close();
        
        // Calculating the end point coordinates
        int endPointX = startPoint[0];
        int endPointY = startPoint[1];
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N': endPointY++; break;
                case 'S': endPointY--; break;
                case 'E': endPointX++; break;
                case 'W': endPointX--; break;
            }
        }
        
        // Calculating the shortest distance between start and end points
        double distance = calculateDistance(startPoint[0], startPoint[1], endPointX, endPointY);
        
        // Printing the output
        System.out.println(distance);
    }
}
