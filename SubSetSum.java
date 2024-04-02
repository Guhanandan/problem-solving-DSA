import java.util.*;

public class SubSetSum {
    ArrayList<Integer> subsetSum(int index[],ArrayList<Integer> arr,int sum[],ArrayList<Integer> ans){
        if(index[0] == arr.size()){
            ans.add(sum[0]);
            return ans;
        }
        subsetSum(new int[]{index[0]+1}, arr, new int[]{sum[0]+arr.get(index[0])}, ans);
        subsetSum(new int[]{index[0]+1}, arr, new int[]{sum[0]}, ans);
        return ans;
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = subsetSum(new int[]{0},arr,new int[]{0} ,new ArrayList<Integer>());
        Collections.sort(ans);
        return ans;
    }
}
