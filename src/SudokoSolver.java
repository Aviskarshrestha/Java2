import java.util.Arrays;

public class SudokoSolver {
    public static void printSudoko(int[][] puzzle) {
        for(int i=0;i<puzzle.length;i++){
            System.out.println();
            for(int j=0;j<puzzle[i].length;j++){
                System.out.print(puzzle[i][j]+" ");
            }
        }
    }
    public static int[][] sudoku(int[][] puzzle) {
        if(puzzle.length!=9 || puzzle[0].length!=9){
            return null;
        }
        if(puzzle==null){
            System.out.println("Puzzle is null");
            return null;
        }

        for (int i = 0; i < puzzle.length; i++) {//find a empty space
            for (int j = 0; j < puzzle[i].length; j++) {
                if(puzzle[i][j] == 0){
                    //firnd all possible numbers for that point
                    int [] currentPos = new int[]{i,j};
                    int[] possibleNumbers = possibleNumbersMaker(currentPos,puzzle);


                    if(possibleNumbers.length==0){
                        return null;
                    }
                    int [][] result;
                    for(int trial=0;trial<possibleNumbers.length;trial++){
                        puzzle[i][j] = possibleNumbers[trial];
                        result=sudoku(puzzle);
                        printSudoko(puzzle);
                        if(result!=null){
                            puzzle=result;
                            break;
                        }
                    }
                    //insert the number
                    //use sudoku() again on the new array
                }
            }
        }
        return puzzle;
    }
    public static int[] possibleNumbersMaker(int[] currentPosition,int [][] puzzle){
        int[] integers=new int[]{1,2,3,4,5,6,7,8,9};
        for(int i=0;i<9;i++){
            int t=puzzle[currentPosition[0]][i];
            integers=Arrays.stream(integers).filter(x->x!=t).toArray();


        }
        for(int i=0;i<9;i++){
            int t=puzzle[i][currentPosition[1]];
            integers=Arrays.stream(integers).filter(x->x!=t).toArray();

        }


        int x=cube(currentPosition)[0];
        int y=cube(currentPosition)[1];
        integers=positionsAvailableCube(x,y,puzzle,integers);
        Arrays.stream(integers).forEach(p->System.out.print(p+" "));
        System.out.println();
        return integers;
    }
    public static int[] cube(int []position){
        int [][] cPoints=new int[][]{{1,1},{1,4},{1,7},{4,1},{4,4},{4,7},{7,1},{7,4},{7,7}};
        int min=100;
        int [] p=new int[2];
        for(int i=0;i<cPoints.length;i++){
            int c=Math.abs(position[0]-cPoints[i][0])+Math.abs(position[1]-cPoints[i][1]);
            if(c<min){
                min=c;
                p=cPoints[i];
            }
        }
        return p;
    }
    public static int[] positionsAvailableCube(int x,int y,int[][]puzzle,int[] integers){

        int nums[]=new int[]{puzzle[x-1][y-1],puzzle[x-1][y],puzzle[x-1][y+1],puzzle[x][y-1],puzzle[x][y],puzzle[x][y+1],puzzle[x+1][y-1],puzzle[x+1][y],puzzle[x+1][y+1]};

        for(int i:nums){
            integers=Arrays.stream(integers).filter(p->p!=i).toArray();
        }
        return integers;
    }
    public static void main(String[] args) {
        int[][] manyZeroes = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        SudokoSolver.printSudoko(SudokoSolver.sudoku(manyZeroes));

    }
}