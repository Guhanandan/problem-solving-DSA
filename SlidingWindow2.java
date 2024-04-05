import java.util.*;

public class SlidingWindow2{
    public static long[] firstNegativeInteger(long[] A,int N ,int K){
        Deque<Integer> deq = new ArrayDeque<Integer>();
        long a[] = new long[N-K+1];
        int index=0;
        for(int i=0;i<N;i++){
            if(!deq.isEmpty() && i-K+1 > deq.peek()){
                deq.pollFirst();
            }
            if(A[i]<0){
                deq.add(i);
            }
            
            if(i>=K-1){
                if(deq.isEmpty())
                    a[index++] = (long)0;
                else
                    a[index++] = A[deq.peekFirst()];
            }
        }
        return a;
    }
    public static void main(String[]arg){
        
        long arr[] = {-4, 9, 6, -8, 12, 3, 15, -8, -1, 7, 5};
        //                   0  0  0  0  0  -8  -8  -8  -1 
        int n = arr.length,k=3;
        long ans[] = new long[n-k+1];
        ans = SlidingWindow2.firstNegativeInteger(arr,n,k);

        for(int i=0;i<n-k+1;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
