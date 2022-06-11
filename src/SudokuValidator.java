import java.util.*;

public class SudokuValidator {
    public static void main(String[] args)
    {
        SudokuValidator sudokuValidator = new SudokuValidator();

        int[][] sudoku =
                {
                        {4,8,9,2,1,3,6,7,5},
                        {5,7,6,9,4,8,3,1,2},
                        {1,3,2,5,7,6,9,8,4},
                        {8,1,4,3,6,5,7,2,9},
                        {2,5,7,4,9,1,8,6,3},
                        {6,9,3,8,2,7,4,5,1},
                        {3,4,5,6,8,2,1,9,7},
                        {7,2,8,1,3,9,5,4,6},
                        {9,6,1,7,5,4,2,3,8}
                };

        if(sudokuValidator.validator(sudoku))
            System.out.println("Given Sudoku is Valid");
        else
            System.out.println("Given Sudoku is  inValid");
    }

    public boolean validator(int[][] sudoku)
    {
        int N =9;
        Set<Integer>[] rows = new HashSet[N];
        Set<Integer>[] cols = new HashSet[N];
        Set<Integer>[] boxs = new HashSet[N];

        for(int i=0; i<N; i++)
        {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            boxs[i] = new HashSet<Integer>();
        }

        for(int r=0; r<N; r++)
        {
            for(int c=0; c<N; c++)
            {
                int val = sudoku[r][c];

                // check for row
                if(rows[r].contains(val))
                    return false;
                rows[r].add(val);

                // check for col
                if(cols[c].contains(val))
                    return false;
                cols[c].add(val);

                // check for box
                int idx = (r/3) * 3 + (c/3);
                if(boxs[idx].contains(val))
                    return false;
                boxs[idx].add(val);
            }
        }
        return true;
    }
}
