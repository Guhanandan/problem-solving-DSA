class QuickSort {
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int getPartition(int arr[],int low,int high){
        int partition_val = arr[low];
        int i=low;
        int j=high;

        while(i<j){
            while(i<high && partition_val>=arr[i]){
                i++;
            }
            while(j>low && partition_val<arr[j]){
                j--;
            }
            if(i<j)
                swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }

    public void quickSort(int arr[],int low,int high){
        if(low<high){
            int partition_index = getPartition(arr,low,high);

            quickSort(arr, low, partition_index-1);
            quickSort(arr, partition_index+1, high);
        }
    }

    public static void main(String[] arg){
        QuickSort obj = new QuickSort();

        int arr[] = {10,8,13,6,34,12,9,18,45,15};
        obj.quickSort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
