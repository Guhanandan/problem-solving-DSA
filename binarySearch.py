
def binarySearchAppr(arr,low,high,x):
    if(low<=high):
        mid = low + (high - low)//2
        if(arr[mid]==x):
            print(f"Element is present at index {mid}")
            return
        elif(arr[mid]<x):
            return binarySearchAppr(arr,mid+1 , high, x)
        else:
            return binarySearchAppr(arr,low , mid-1, x)
            
    print("Element is not present in array")
    return 


arr = ["one", "three", "five", "seven", "nine", "eleven", "thirteen"]
x = "eleven"
arr.sort()
binarySearchAppr(arr, 0, len(arr)-1, x)