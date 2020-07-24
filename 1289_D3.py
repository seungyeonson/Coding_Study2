T = int(input())
for tc in range(T):
    answer=0
    arr = list(input()) #0011
    test = ['0']*len(arr)  #0000
    for i in range(len(arr)):
        # 만약 탐색하면서 같으면 패스
        # 아니면 나머지 자리 반대로 바꾸기=>test를 + 바꾸면 answer+=1
        if arr[i] == test[i]:
            continue
        elif arr[i] != test[i]:
            answer+=1
            for j in range(i,len(arr)):
                test[j] = arr[i]


    print("#"+str(tc+1), answer)
