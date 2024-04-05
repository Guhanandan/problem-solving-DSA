class Solution
{
    static void arrange(long arr[], int n)
    {
        // your code here
        long N = (long)n;
        
        for(int i=0;i<n;i++){
            arr[i] = arr[i]+(arr[(int) arr[i]]%N)*N;
        }
        for(int i=0;i<n;i++){
            arr[i]/=N;
        }
    }
}

class rearrange {
    public static void main(String arg[]){
        //Solution ob = new Solution();
        long arr[] = {6,3,9,1,5,2,0,8,4,7};
        int n = (int)arr.length;
        Solution.arrange(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
