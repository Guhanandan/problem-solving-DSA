class MergeSort {
    public void merge(int arr[],int low ,int mid,int high){
        int n1 = mid-low+1;
        int n2 = high-mid;

        int L[] = new int[n1];
        int R[] = new int[n2];
    
        for(int k=0;k<n1;k++)
            L[k] = arr[low+k];
        for(int l=0;l<n2;l++)
            R[l] = arr[mid+1+l];

        int i = 0,j=0;
        int index = low;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[index++] = L[i++];
            }
            else{
                arr[index++] = R[j++];
            }
        }

        while(i<n1){
            arr[index++] = L[i++];
        }

        while(j<n2){
            arr[index++] = R[j++];
        }
    }

    public void mergeSort(int arr[],int low,int high){
        if(low==high){
            return ;
        }
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void main(String[] arg){
        MergeSort obj = new MergeSort();

        
        int arr[] = {10,12,19,5,6,8,5,4,3,2,14, 34, 91, 68, 69, 1, 89, 50, 4, 64, 54, 87, 53, 76, 58, 37, 15, 61, 29, 51, 57, 95, 100, 40, 29, 1, 48, 60, 36};
        int low = 0,high = arr.length-1;
        obj.mergeSort(arr,low,high);

        for(int i=0;i<high+1;i++){
            System.out.println(arr[i]);
        }
    }    
}
