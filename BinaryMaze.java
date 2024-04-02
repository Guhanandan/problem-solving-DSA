import java.util.ArrayList;
import java.util.List;
class BinaryMaze{
    static class Pair{
        int dist,row,coln;
        Pair(int dist,int row,int coln){
            this.dist = dist;
            this.row = row;
            this.coln = coln;
        }
    }

    class Solution {

        static boolean dfs(int node,int visited[],int pathVisited[],List<List<Integer>> adj){
            visited[node] = 1;
            pathVisited[node] = 1;
            List<Integer> temp = adj.get(node);
            boolean isCycle = false;
            for(int i=0;i<temp.size();i++){
                if(visited[temp.get(i)]==1 && pathVisited[i]==1){
                    return true;
                }
                if(visited[temp.get(i)]!=1){
                    isCycle = dfs(temp.get(i),visited,pathVisited,adj);
                }
                if(!isCycle){
                    pathVisited[temp.get(i)] = 0;
                }
            }
            if(isCycle){
                return true;
            }
            return false;
        }
        
        static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
            List<Integer> ans = new ArrayList<Integer>();
            int visited[] = new int[V];
            int pathVisited[] = new int[V];
            
            for(int i=0;i<V;i++){
                if(visited[i]!=1){
                    dfs(i,visited,pathVisited,adj);
                }
            }
            
            for(int i=0;i<V;i++){
                if(pathVisited[i]==1)
                {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
    public static void main(String arg[]){
        List<List<Integer>> adj = new ArrayList<>();
        int V = 7;
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(2);
        adj.add(temp1);
        
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(2);
        temp2.add(3);
        adj.add(temp2);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(5);
        adj.add(temp3);

        List<Integer> temp4 = new ArrayList<>();
        temp4.add(0);
        adj.add(temp4);

        List<Integer> temp5 = new ArrayList<>();
        temp5.add(5);
        adj.add(temp5);
        List<Integer> temp6 = new ArrayList<>();
        adj.add(temp6);
        List<Integer> temp7 = new ArrayList<>();
        adj.add(temp7);
        
        List<Integer> answer = BinaryMaze.Solution.eventualSafeNodes(V,adj);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}