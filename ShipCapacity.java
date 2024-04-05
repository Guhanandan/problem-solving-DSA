import java.util.*;

public class ShipCapacity {
    public static boolean leastCapacity(int arr[],int d,int capacity){
        int current_capacity = 0;
        int daycount=0;
        boolean ans;
        for(int i=0;i<arr.length;i++){
            current_capacity+=arr[i];
            if(current_capacity>capacity){
                daycount+=1;
                current_capacity = arr[i];
            }
            if(current_capacity==capacity){
                daycount+=1;
                if(i!=arr.length-1){
                    current_capacity = 0;
                }
            }
        }
        if(current_capacity<capacity){
            daycount+=1;        }
        if(current_capacity>capacity){
            daycount+=1;
        }
        if(daycount<=d){
            ans =  true;
        }
        else{
            ans = false;
        }
        return ans ;
    }

    public static int minimumCapacity(int arr[],int day){

        int start = Arrays.stream(arr).max().orElseThrow();
        int end = Arrays.stream(arr).sum();
        if(ShipCapacity.leastCapacity(arr,day,start)){
            return start;
        }
        while(start<end){
            if(start == end-1){
                break;
            }
            int mid = start+(end - start)/2;
            boolean least_capacity = ShipCapacity.leastCapacity(arr,day,mid);
            if(least_capacity){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        return end;
    }

    public static void main(String arg[]){
        int arr[] = {9,8,10};
        int day = 3;
        int minimum_capacity = ShipCapacity.minimumCapacity(arr,day);
        System.out.println(minimum_capacity);
    }
}
