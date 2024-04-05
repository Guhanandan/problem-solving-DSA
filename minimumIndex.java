class prog{
    static int maxIndexDiff(int A[], int N) { 
        
        int minArr[] = new int[N];
        int maxArr[] = new int[N];
        
        int min_value = A[0];
        
        int max_value = A[N-1];
        
        minArr[0] = min_value;
        maxArr[N-1] = max_value;
        
        for(int i=1;i<N;i++){
            minArr[i] = Math.min(min_value,A[i]);
            min_value = Math.min(min_value,minArr[i]);
        }
        
        for(int i=N-2;i>=0;i--){
            maxArr[i] = Math.max(max_value,A[i]);
            max_value = Math.max(max_value,maxArr[i]);
            
        }
        int i=0,j=0,max_index=-1;

        while(i<N && j<N){
            if(minArr[i]<=maxArr[j]){
                max_index = Math.max(max_index,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        System.out.println();
        return max_index;
    }

    public static void main(String arg[]){
        int arr[] = {9,3,18,7,12,63,2,14,3,1,5};
        int n = prog.maxIndexDiff(arr, arr.length);
        System.out.println(n);
    }
}