import java.util.*;

class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr,int index[],ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans,int target[]){
        if(index[0] == arr.size())
        {
            if(target[0] == 0){
                ans.add(new ArrayList<>(ds));
            }
            return ans;
        }

        if(target[0]>=arr.get(index[0])){
            ds.add(arr.get(index[0]));
            combinationSum(arr, index, ds, ans,new int[]{target[0]-arr.get(index[0])});
            ds.remove(ds.size()-1);
        }
        combinationSum(arr,new int[]{index[0]+1}, ds, ans, target);
        return ans;
    }
    
    public static void main(String[] arg){
        ArrayList<Integer> arr = new ArrayList<>(List.of(7,2,6,5));
        Collections.sort(arr);
        int target[]  = {16};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = CombinationSum.combinationSum(arr,new int[]{0},new ArrayList<>(),ans,target);
        for(int i=0;i<ans.size();i++){
            ArrayList<Integer> list = ans.get(i);
            for(int a : list)
                System.out.print(a+" ");
            System.out.println();
        }
    }
}
