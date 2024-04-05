import java.util.Arrays;
class TripletSum {
    public static boolean isTriplet(int[] arr , int sum){
        int n = arr.length;
        boolean ans = false;
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            int start = i+1,end = n-1;
            
            while(start<end){
                if(arr[i]+arr[start]+arr[end]==sum){
                    ans = true;
                    return ans;
                }
                else if(arr[i]+arr[start]+arr[end]<sum){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] arg){
        int sum = 13;
        int[] arr = {1 ,4 ,45, 6 ,10, 8};
        System.out.println(TripletSum.isTriplet(arr,sum));
    }
}
