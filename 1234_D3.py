for tc in range(10):
    N, M = input().split()
    N = int(N)
    arr = list(M)
    answer = 0
    Flag = True
    while(Flag):
        Flag = False
        for i in range(N-1):

            if arr[i] == arr[i+1] and arr[i]!="" and arr[i+1]!="":
                Flag = True
                del arr[i + 1]
                del arr[i]

                arr.append("")
                arr.append("")

    print("#"+str(tc+1),end=" ")
    for i in arr:
        print(i,end="")
    print()
