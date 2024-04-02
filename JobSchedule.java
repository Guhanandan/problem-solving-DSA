
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}


public class JobSchedule {
    int[] findJobScheduling(Job arr[], int n)
    {
        int ans[] = new int[2];
        Arrays.sort(arr,(a,b) -> (b.profit - a.profit));
        
        int maxi = 0;
        for(int i=0;i<arr.length;i++){
            if(maxi<arr[i].deadline){
                maxi = arr[i].deadline;
            }
        }
        //System.out.println(maxi);
        int job[] = new int[maxi+1];
        int profit = 0;
        int jobCount=0;
        for(int i=0;i<job.length;i++){
            job[i] = -1;
        }
        
        for(int i=0;i<arr.length;i++){
            Job temp = arr[i];
            for(int j=temp.deadline;j>0;j--){
                if(job[j]==-1){
                    job[j] = temp.id;
                    profit+=temp.profit;
                    jobCount++;
                    break;
                }
            }
        }
        
        ans[0] = jobCount;
        ans[1] = profit;
        return ans;
    }
    public static void main(String arg[]){
        JobSchedule obj = new JobSchedule();
        int ans[] = new int[2];
        Job[] jobArray = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 1, 15)
        }; 
        ans = obj.findJobScheduling(jobArray,jobArray.length);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}