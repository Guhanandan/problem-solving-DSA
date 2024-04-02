class CountInversion {
    public long merge(long arr[],int low ,int mid,int high){
        int count = 0;
        int n1 = mid-low+1;
        int n2 = high-mid;

        long L[] = new long[n1];
        long R[] = new long[n2];

        for(int i=0;i<n1;i++){
            L[i] = arr[low+i];            
        }

        for(int i=0;i<n2;i++){
            R[i] = arr[mid+1+i];
        }

        int i = 0,j = 0,index = low;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[index++] = L[i++];
            }
            else{
                count+=n1-i;
                arr[index++] = R[j++];
            }
        }

        while(i<n1){
            arr[index++] = L[i++];
        }

        while(j<n2){
            arr[index++] = R[j++];
        }

        return count;
    }

    public long mergeSort(long arr[],int low,int high){
        long count = 0;
        if(low>=high){
            return count;
        }
        int mid = (low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }
    public static void main(String[] arg){
        CountInversion obj = new CountInversion();

        
        long arr[] = {468 ,335 ,1 ,170 ,225, 479 ,359 ,463, 465 ,206 ,146 ,282, 328 ,462, 492 ,496 ,443, 328, 437 ,392 ,105, 403 ,154, 293, 383 ,422 ,217 ,219 ,396 ,448 ,227 ,272 ,39 ,370, 413, 168 ,300 ,36 ,395 ,204 ,312 ,323}; //10,12,19,3,29,6,8,15,20,3,2,14, 34, 91, 68, 69, 1, 89, 50, 4, 64, 54, 87, 53, 76, 58, 37, 15, 61, 29, 51, 57, 95, 100, 40, 29, 1, 48, 60, 36};
        int low = 0,high = arr.length-1;
        //int mid = (low+high)/2;
        long count = obj.mergeSort(arr,low,high);

        // for(int i=0;i<high+1;i++){
        //     System.out.println(arr[i]);
                //468 335 1 170 225 479 359 463 465 206 146 282 328 462 492 496 443 328 437 392 105 403 154 293 383 422 217 219 396 448 227 272 39 370 413 168 300 36 395 204 312 323

        // }
        System.out.println(count);
        /*
         * if(low==high){
            return count;
        }
        int mid = (low+high)/2;
        count += mergeSort(arr,low,mid,count);
        count += mergeSort(arr,mid+1,high,count);
        return merge(arr,low,mid,high);
         */
    }    
}
