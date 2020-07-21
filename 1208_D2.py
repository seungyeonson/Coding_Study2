
for case in range(10):
    N = int(input())
    arr = list(map(int, input().split()))

    answer = 0
    arr = sorted(arr)
    for i in range(N):
        arr[-1] -= 1
        arr[0] += 1
        arr = sorted(arr)

    answer = arr[-1] - arr[0]

    print('#'+str(case+1), answer)