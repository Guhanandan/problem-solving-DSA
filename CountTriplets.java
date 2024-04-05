import java.util.Arrays;

class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);

        long result = 0;
	    
	    for(int i=0;i<n-1;i++){
	        int j = i+1;
	        int k = n-1;
	        while(j<k){
	            if(arr[i]+arr[j]+arr[k]<sum){
	                result++;
	                j++;
	            }
	            else{
	                k--;
	            }
	        }
	    }
	    return result;
    }

    
}

class CountTriplets{
	public static void main(String arg[]){
        Solution s = new Solution();
        long[] arr = {-2, 0, 1, 3};
        System.out.println(s.countTriplets(arr,arr.length,2));
    }
}
