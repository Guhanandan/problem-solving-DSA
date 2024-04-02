def merge(low,mid,high,arr):
    left = []
    for i in range(low,mid+1):
        left.append(arr[i])
    
    right = []
    for i in range(mid+1,high+1):
        right.append(arr[i])
    
    lIndex,rIndex = 0,0
    arrIndex = low
    while lIndex < len(left) and rIndex < len(right):
        if(left[lIndex]<right[rIndex]):
            arr[arrIndex] = left[lIndex]
            lIndex+=1
            arrIndex+=1
        else:
            arr[arrIndex] = right[rIndex]
            rIndex+=1
            arrIndex+=1
    
    while lIndex < len(left):
        arr[arrIndex] = left[lIndex]
        arrIndex+=1
        lIndex+=1
    
    while rIndex < len(right):
        arr[arrIndex] = right[rIndex]
        rIndex+=1
        arrIndex+=1
    #print(arr)
    

def mergeSort(low,high,arr):
    if(low<high):
        mid = (low+high)//2
        mergeSort(low,mid,arr)
        mergeSort(mid+1,high,arr)
        merge(low,mid,high,arr)

def Merge_Sort():
    arr = [ 2, 3,4, 1, 5, 6,23,21,18,8,17]
    #merge(0,2,4,arr)
    mergeSort(0,len(arr)-1,arr)
    print(arr)
Merge_Sort()
"""arr = [ 2, 3, 4,17, 1, 5, 6,14]
merge(0,3,len(arr)-1,arr)
print(arr)"""

