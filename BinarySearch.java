//hello all
public class BinarySearch {
    public static int binarySearch(int[] arr,int k,int start,int end){

        if(start<=end){

            int mid = start+(end-start)/2;

            if(arr[mid]==k){
                return mid;
            }
            else if(arr[mid]<k){
                return binarySearch( arr, k, mid+1, end);
            }
            else{
                return binarySearch( arr, k, start, mid-1);
            }
        }
        return -1;
    }
    public static void main(String arg[]){
        //Solution ob = new Solution();
        int arr[] = {3,12,16,19,25,26,34,89,111,141};
        //Arrays.sort(arr);
        int key = 111;
        int index = BinarySearch.binarySearch(arr,key,0,arr.length-1);
        System.out.println(index);
    }
}
