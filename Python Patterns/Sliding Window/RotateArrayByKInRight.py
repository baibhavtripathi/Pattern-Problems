
def swap( arr, a, b):
    arr[a] ^= arr[b]
    arr[b] ^= arr[a]
    arr[a] ^= arr[b]
        
def rotate( nums, k):
    n = len(nums)
    k %= n
    reverseArr(nums, 0, n)
    reverseArr(nums, 0, k)
    reverseArr(nums, k, n)

        
def reverseArr( arr, start, end):
    while start < end:
        swap(arr, start, end)
        start += 1
        end -= 1
arr = [1,2,3,4,5]
rotate(arr , 2)
print(arr)