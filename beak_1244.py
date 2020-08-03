#스위치 켜고 끄기
T = int(input())
arr =list(map(int, input().split()))
N = int(input())
order = []
for i in range(N):
    order.append(list(map(int, input().split())))
for i in range(N):
    if order[i][0] == 1:
        temp = order[i][1] -1
        j = temp
        while(j<len(arr)):
            if arr[j] == 0:
                arr[j] = 1
            else:
                arr[j] = 0
            j += temp + 1
    elif order[i][0] == 2:
        temp = order[i][1] - 1
        temp_a = []
        k = 1
        if temp == order[i][1] - 1:
            temp_a.append(temp)
        while 0<=temp - k and temp + k<T:
            if arr[temp-k] == arr[temp+k]:
                temp_a.append(temp-k)
                temp_a.append(temp+k)
                k += 1
            else:
                break
        for p in range(len(temp_a)):
            if arr[temp_a[p]] == 0:
                arr[temp_a[p]] = 1
            else:
                arr[temp_a[p]] = 0

for i in range(len(arr)):
    print(arr[i], end=" ")
    if(i%20==19):
        print()