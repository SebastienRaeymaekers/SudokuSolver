import java.util.*;

public class SudokuSolver {

    int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public boolean possible(int x, int y, int value) {
        this.grid[x][y] = value;
        boolean isPossible = validRow(x, y) && validColumn(x, y) && validBlock(x, y);
        this.grid[x][y] = 0;
        return isPossible;
    }

    public boolean validRow(int x, int y) {
        int[] row = this.grid[x];
        return !duplicatesPresent(row);
    }

    public boolean validColumn(int x, int y) {
        int[] column = new int[9];
        for(int i = 0; i < grid[0].length; i++){
            column[i] = grid[i][y];
        }
        return !duplicatesPresent(column);
    }

    public boolean validBlock(int x, int y) {
        int i = Math.floorDiv(y, 3);
        int j = Math.floorDiv(x, 3);

        int[] block = new int[9];
        int v = 0;
        for(int r = j*3; r < (j*3)+3; r++) {
            for(int c = i*3; c < (i*3)+3; c++) {
                block[v] = grid[r][c];
                v++;
            }
        }
        return !duplicatesPresent(block);
    }

    public boolean duplicatesPresent(int[] array) {
        Set<Integer> set = new HashSet<Integer>();
        for (int j : array) {
            if(j == 0) continue; // skip 0 values.
            if (!set.add(j)) return true; //If same integer is already present then add method will return FALSE
        }
        return false;
    }
}