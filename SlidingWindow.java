import java.util.*;
class SlidingWindow {
    public static ArrayList<Integer> findMaximum(int arr[] , int k){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deq = new ArrayDeque<>();

        for(int i=0;i<arr.length;i++){
            if(!deq.isEmpty() && i-k+1>deq.peek()){
                deq.pollFirst();
            }
            while(!deq.isEmpty() && arr[deq.peekLast()]<arr[i]){
                deq.pollLast();
            }
            deq.add(i);
            if(i>=k-1){
                ans.add(arr[deq.peekFirst()]);
            }
        }
        return ans;
    }
    public static void main(String[]arg){
        ArrayList<Integer> l = new ArrayList<Integer>();
        int arr[] = {0,0,0,0,0,0};
        l = SlidingWindow.findMaximum(arr,2);

        for(int i : l)
            System.out.print(i+" ");
    }
}
