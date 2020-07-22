T = int(input())
for tc in range(T):
    arr = []
    N = int(input())
    for i in range(N):
        arr.append(list(input()))
    for i in range(N):
        for j in range(N):
            arr[i][j] = int(arr[i][j])

    print(arr)
