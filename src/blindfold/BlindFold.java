/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blindfold;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class BlindFold {

    static int rows;
    static int cols;
    static char[][] grid;

    static char[] steps;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        grid = new char[rows][cols];
        sc.nextLine();
        for (int i = 0; i < rows; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int n = sc.nextInt();
        sc.nextLine();
        steps = new char[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            steps[i] = s.charAt(0);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int direction = 0; direction < 4; direction++) {
                    goWithStart(row, col, direction);
                    
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }

    }

    private static void goWithStart(int row, int col, int direction) {
        if (!valid(row, col)) {
            return;
        }
        for (int i = 0; i < steps.length; i++) {
            switch (steps[i]) {
                case 'F':
                    switch (direction) {
                        case 0:
                            col++;
                            break;
                        case 1:
                            row--;
                            break;
                        case 2:
                            col--;
                            break;
                        case 3:
                            row++;
                            break;
                        default:
                            break;
                    }
                    if (!valid(row, col)) {
                        return;
                    }
                    break;
                case 'L':
                    direction = (direction + 1) % 4;
                    break;
                case 'R':
                    direction = (direction + 3) % 4;
                    break;
                default:
                    break;
            }
        }
        grid[row][col]='*';
    }

    private static boolean valid(int row, int col) {
        if (row < 0 || row >= rows) {
            return false;
        }
        if (col < 0 || col >= cols) {
            return false;
        }
        if (grid[row][col] == 'X') {
            return false;
        }
        return true;
    }
}
