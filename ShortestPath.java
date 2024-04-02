import java.util.ArrayList;
import java.util.Stack;

//User function Template for Java
class Solution {
    static class Pair{
        int node,dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void topoSort(int n,int visited[],ArrayList<ArrayList<Pair>> adj,Stack<Integer> st){
        visited[n] = 1;
        ArrayList<Pair> temp = adj.get(n);
        for(int i=0;i<temp.size();i++){
            if(visited[temp.get(i).node]!=1){
                topoSort(temp.get(i).node,visited,adj,st);
            }
        }
        st.add(n);
    }
    
    public static int[] shortestPat(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        
        for(int i=0;i<M;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int dt = edges[i][2];
            adj.get(u).add(new Pair(v,dt));
        }
        
        int visited[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++){
            if(visited[i]!=1){
                topoSort(i,visited,adj,st);
            }
        }
        
        int dist[] = new int[N];
        for(int i=0;i<N;i++){
            dist[i] = (int)(1e9);
        }

        dist[0] = 0;
        while(!st.isEmpty()){
            int currNode = st.pop();
            int curDist = dist[currNode];
        //  System.out.println(currNode);
        //  System.out.println(curDist);
            ArrayList<Pair> temp = adj.get(currNode);
            for(int i=0;i<temp.size();i++){
                Pair pair = temp.get(i);
                //System.out.println(pair.node+" "+pair.dist);
                if(curDist+pair.dist<dist[pair.node]){
                    dist[pair.node] = curDist+pair.dist;
                }
            }
        }
        
        return dist;
    }
    public static void main(String arg[]){
        //ShortestPath obj = new ShortestPath();
        int N = 6, M = 7;
        int edge[][] = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int ans[] = Solution.shortestPat(N,M,edge);
        for(int i=0;i<N;i++){
            System.out.println(ans[i]+" ");
        }
    }
}

