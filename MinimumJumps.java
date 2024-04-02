class MinimumJumps{
    public int minJumps(int jumps[],int N){
        int jumpCount=0,maxReachable=0,current=0;

        for(int i=0;i<N;i++){
            maxReachable = Math.max(maxReachable, i+jumps[i]);
            if(current==i){
                jumpCount++;
                current = maxReachable;
            }
        }
        return jumpCount;
    }
    public static void main(String arg[]){
        MinimumJumps obj = new MinimumJumps();
        int jumps[] = {2,2,5,3,2,4,3,2,5};
        System.out.println(obj.minJumps(jumps,jumps.length));
    }
}