import java.util.*;

class Solution{
    List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tempst = new Stack<>();
        list.add(-1);
        
        for(int i=1;i<n;i++){
            int val = a[i];
            st = tempst;
            while(!st.isEmpty() && val<=st.peek()){
                st.pop();
            }
            
            if(st.isEmpty()){
                list.add(-1);
            }
            else{
                list.add(st.peek());
            }
            tempst.add(val);
        }
        
        return list;
    }
}


public class SmallerOnLeft {
    public static void main(String[] arg){
        int arr[] = {4,76,13,88,96,24};
        List<Integer> a = new ArrayList<>();
        Solution s = new Solution();
        System.out.println("Hello");
        
        a = s.leftSmaller(arr.length, arr);
        for(int i : a){
            System.out.println(i);
        }
    }
}

