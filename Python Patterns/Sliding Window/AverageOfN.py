# Time Complexity : O(N)
# Space Compleity : O(N-K+1)
def averageUsingSlidingWindow(arr, n):
    res = []
    aggregate = sum(arr[0:n])
    res.append(aggregate/n)
    for i in range(1, len(arr)-n+1):
        aggregate -= (arr[i-1]-arr[i+n-1])
        res.append(aggregate/n)
    return res
if __name__ == "__main__":
    print(averageUsingSlidingWindow([1, 3, 2, 6, -1, 4, 1, 8, 2], 5))