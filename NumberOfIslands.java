import java.util.Queue;
import java.util.LinkedList;

class NumberOfIslands {
    class Pair{
        int row,coln;
        Pair(int row,int coln){
            this.row = row;
            this.coln = coln;
        }
    }
    public void findIsland(int row,int coln,char[][] grid,int visited[][]){
        int n = grid.length;
        int m = grid[0].length;
        
        visited[row][coln] = 1;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row,coln));
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int newRow = temp.row+i;
                    int newColn = temp.coln+j;
                    if(newRow>=0 && newRow<n && newColn>=0 && newColn<m && grid[newRow][newColn]!='0' && visited[newRow][newColn]!=1){
                        queue.add(new Pair(newRow,newColn));
                        visited[newRow][newColn] = 1;
                    }
                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int coln = grid[0].length;
        int visited[][] = new int[row][coln];
        int count = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<coln;j++){
                if(grid[i][j]=='1' && visited[i][j]!=1){
                    count++;
                    findIsland(i,j,grid,visited);
                }
            }
        }
        
        return count;
    }

    public static void main(String arg[]){
        NumberOfIslands obj = new NumberOfIslands();
        char grid[][] = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        System.out.println(obj.numIslands(grid));
    }
}