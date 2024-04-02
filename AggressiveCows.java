import java.util.Arrays;

class JavaHelper{
    public static boolean isMinimumDistant(int d,int k,int n,int stalls[]){

        int count_cows = 1;
        int last_cow = stalls[0];

        for(int i=1;i<n;i++){
            if(stalls[i]-last_cow>=d){
                count_cows+=1;
                last_cow = stalls[i];
            }
        }

        if(count_cows<k){
            return false;
        }
        else{
            return true;
        }
    }

    public static int aggresiveCows(int n,int k,int stalls[]){
        if(k>n){
            return -1;
        }

        Arrays.sort(stalls);
        int max_dist = stalls[n-1] - stalls[0];
        int start = 1,end = max_dist;

        while(start<end){
            if(start == end-1){
                break;
            }
            int mid = start + (end-start)/2;

            if(isMinimumDistant(mid,k,n,stalls)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return start;
        //System.out.println(isMinimumDistant(2,k,n,stalls));
        //return 0;
        
    }
    public static void main(String arg[]){
        int n=6;
        int k=5;
        int stalls[] = {2 ,12 ,11 ,3 ,26 ,7};
        System.out.println(aggresiveCows(n, k, stalls));
    }
}