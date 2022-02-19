import java.util.Arrays;

public class Solver {

    private static int[][] grid = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    private static final SudokuSolver sudokuSolver = new SudokuSolver(grid);

    public static void printSudoku(){
        for(int[] ar: grid) System.out.println(Arrays.toString(ar));
    }

    public static boolean solve(){
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0) {
                    for (int v = 1; v < grid.length+1; v++) {
                        if(sudokuSolver.possible(row,col,v)){
                            grid[row][col] = v;
                            boolean solved = solve();
                            if(solved) return true;
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("----Sudoku----");
        printSudoku();
        solve();
        System.out.println("----Solved Sudoku----");
        printSudoku();
    }
}