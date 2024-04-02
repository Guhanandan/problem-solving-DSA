import java.util.Queue;
import java.util.LinkedList;
class Pair{
    int row,coln,dist;
    Pair(int row,int coln,int dist){
        this.row = row;
        this.coln = coln;
        this.dist = dist;
    }
}

public class DistanceOfCell {
    class Pair{
        int row,coln,dist;
        Pair(int row,int coln,int dist){
            this.row = row;
            this.coln = coln;
            this.dist = dist;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int ans[][] = new int[grid.length][grid[0].length];
        int visited[][] = new int[grid.length][grid[0].length];
        int delRow[] = {-1,0,1,0};
        int delColn[] = {0,1,0,-1};
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            for(int i=0;i<4;i++){
                int curRow = temp.row+delRow[i];
                int curColn = temp.coln+delColn[i];
                
                if(curRow>=0 && curRow<n && curColn>=0 && curColn<m && visited[curRow][curColn]!=1){
                    queue.add(new Pair(curRow,curColn,temp.dist+1));
                    ans[curRow][curColn] = temp.dist+1;
                    visited[curRow][curColn]=1;
                }
            }
        }
        return ans;
    }
    public static void main(String arg[]) {
        DistanceOfCell obj = new DistanceOfCell();
        int [][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        int ans[][] = obj.nearest(grid);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
