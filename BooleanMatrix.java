import java.util.HashSet;

public class BooleanMatrix{
    public static void booleanMatrix(int[][] Matrix){
        HashSet<Integer> set_i = new HashSet<>();
        HashSet<Integer> set_j = new HashSet<>();
        int row = Matrix.length,col = Matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(Matrix[i][j]==1){
                    set_i.add(i);
                    set_j.add(j);
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(set_i.contains(i) || set_j.contains(j)){
                    Matrix[i][j] = 1;
                }
            }
        }
    }
    public static void print(int[][] Matrix){
        int row = Matrix.length,col = Matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(Matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] arg){
        int[][] Matrix = {{1,0,0},{0,0,0}};
        BooleanMatrix.booleanMatrix(Matrix);
        BooleanMatrix.print(Matrix);
    }
}
