import java.util.*;


public class CycleInDirectedGraph{

    boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int visited[],int pathVisited[]){
        visited[node] = 1;
        pathVisited[node] = 1;
        ArrayList<Integer> vertex = adj.get(node);

        for(int eachNode : vertex){
            if(visited[eachNode]==0){
                if(dfs(eachNode, adj, visited, pathVisited)==true){
                    return true;
                }
            }
            else if(pathVisited[eachNode]==1){
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }

    boolean isCyclic(int V,ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int[V];
        int pathVisited[] = new int[V];

        for(int i=0;i<V;i++){
            if(visited[i]!=1){
                if(dfs(i,adj,visited,pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String arg[]){
        CycleInDirectedGraph obj = new CycleInDirectedGraph();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        ArrayList<Integer> temp0 = new ArrayList<>();
        temp0.add(1);
        adj.add(temp0);

        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(2);
        adj.add(temp1);

        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(3);
        temp2.add(6);
        adj.add(temp2);

        ArrayList<Integer> temp3 = new ArrayList<>();
        temp3.add(4);
        adj.add(temp3);

        ArrayList<Integer> temp4 = new ArrayList<>();
        temp4.add(5);
        adj.add(temp4);

        ArrayList<Integer> temp5 = new ArrayList<>();
        temp5.add(3);
        adj.add(temp5);

        ArrayList<Integer> temp6 = new ArrayList<>();
        temp6.add(4);
        adj.add(temp6);

        ArrayList<Integer> temp7 = new ArrayList<>();
        temp7.add(1);
        temp7.add(8);
        adj.add(temp7);

        ArrayList<Integer> temp8 = new ArrayList<>();
        temp8.add(9);
        adj.add(temp8);

        ArrayList<Integer> temp9 = new ArrayList<>();
        temp9.add(6);
        adj.add(temp9);
       
        System.out.println(obj.isCyclic(10,adj));
    }
}