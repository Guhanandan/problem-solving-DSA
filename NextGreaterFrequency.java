import java.util.*;

public class NextGreaterFrequency {
    public static int[] nextGreaterFreq(int[] arr,int n){
        
        int[] ans = new int[n];
        int ans_index = 0;
        ans[n-1] = -1;
        
        Stack<Integer> tempst = new Stack<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
        int index = n-1;
        int max = 0;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            int freq = map.get(arr[i]);
            if(freq>max){
                max = freq;
            }
            st.push(arr[index--]);
        }
        int key = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue()==max){
                key = m.getKey();
                break;
            }
        }

        st.pop();

        for(int i=0;i<n-1;i++){
            
            tempst.clear();
            tempst.addAll(st);

            while(!tempst.empty()){
                if(tempst.peek()==key){
                    ans[ans_index++] = -1;
                    
                    break;
                }
                if(map.get(tempst.peek())>map.get(arr[i])){
                    ans[ans_index++] = tempst.peek();
                    break;
                }
                tempst.pop();
            }
            if(tempst.empty()){
                ans[ans_index++] = -1;
            }
            if(st.empty()){
                break;
            }
            st.pop();
        }
        return ans;
    }
    public static void main(String[] arg){
        long startTime = System.nanoTime();
        int arr[] = {5,2,7,5,0,8,6,5,21,1,9,5,3,4};
        int ans[] = new int[arr.length];

        ans = NextGreaterFrequency.nextGreaterFreq(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(ans[i]);
        }
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000; // Convert to milliseconds

        System.out.println("Execution time: " + elapsedTime + " ms");
    }
}
