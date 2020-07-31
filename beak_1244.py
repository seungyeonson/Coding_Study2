#스위치 켜고 끄기
T = int(input())
arr =list(map(int, input().split()))
N = int(input())
order = []
for i in range(N):
    order.append(list(map(int, input().split())))
for i in range(N):
    if order[i][0] == 1:
        temp = order[i][1]
        j = temp
        while(j<=len(arr)):
            if arr[j-1] == 0:
                arr[j - 1] = 1
            else:
                arr[j-1] = 0
            j += temp
    elif order[i][1] ==2:
        pass
for i in range(len(arr)):
    print(arr[i],end=" ")