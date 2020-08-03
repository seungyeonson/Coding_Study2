
T = int(input())
for tc in range(T):
    N = int(input())
    arr = [0]*(N+2)

    arr[0] = 1
    arr[1] = 0
    if(N<1):
        pass
    else:
        for i in range(1,N+1):
            arr[i+1] = arr[i] + arr[i-1]
            #print(arr[i+1])
    print(arr[N],arr[N+1])
    #print()
