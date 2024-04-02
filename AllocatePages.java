import java.util.Arrays;

public class AllocatePages {
    public static int numberOfPainters(int paints[],int n,int capacity){
        int painter_count = 1;
        int curr_capacity = paints[0];
        
        for(int i=1;i<n;i++){
            curr_capacity+=paints[i];
            if(curr_capacity>capacity){
                painter_count+=1;
                
                curr_capacity = paints[i];
                
            }
        }
        // if(curr_capacity<=capacity){
        //     painter_count+=1; 
        // }
        return painter_count;
    }

    public static long allocateMinPaints(int paints[],int n,int painters){
        int start = Arrays.stream(paints).max().orElseThrow();
        int end = Arrays.stream(paints).sum();
        
        if(numberOfPainters(paints,n,start)<painters){
            return -1;
        }
        if(numberOfPainters(paints,n,start)==painters){
            return start;
        }

        while(start<end){
            if(start==end-1){
                break;
            }

            int mid = start + (end-start)/2;
            int curr_painters = numberOfPainters(paints,n,mid);
            if(curr_painters<=painters){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        return (long)start+1; 
        
    }

    public static void main(String arg[])
    {
        int paints[] = {5,10,30,20,15};
        int n = paints.length;
        int painters = 3;
        System.out.println(AllocatePages.allocateMinPaints(paints,n,painters));
    }
}
