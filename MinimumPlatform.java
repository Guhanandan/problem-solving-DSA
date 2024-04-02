import java.util.*;
public class MinimumPlatform {
    public int findMinimumPlatforms(int arr[],int dep[]){
        int maxi = 1,platform=1,depIndex=0;

        for(int i=1;i<arr.length;i++){
            if(dep[depIndex]<arr[i]){
                depIndex++;
            }
            else if(dep[depIndex]>=arr[i]){
                platform +=1;
                maxi = Math.max(maxi,platform);
            }
        }
        return maxi;
    }
    public static void main(String arg[]){
        MinimumPlatform obj = new MinimumPlatform();
        int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
        int dep[] = {940, 1200, 1120, 1130, 1900, 2000};
        
        Arrays.sort(arr);
        Arrays.sort(dep);

        System.out.println(obj.findMinimumPlatforms(arr,dep));
    }
}
