T = int(input())
for tc in range(T):
    answer = 1
    arr = []
    for i in range(9):
        arr.append(list(map(int, input().split())))
    LIST_reverse = list(map(list, zip(*arr)))
    dx = [0, 0, 0, 3, 3, 3, 6, 6, 6]
    dy = [0, 3, 6, 0, 3, 6, 0, 3, 6]
    #가로검사
    for i in range(9):
        temp = set(arr[i])
        temp_1 = set(LIST_reverse[i])
        temp_2 = []
        for j in range(3):
            for k in range(3):
                temp_2.append(arr[dx[i]+j][dy[i]+k])
        temp_2 = set(temp_2)


        if(len(temp) != 9 or len(temp_1) != 9 or len(temp_2) != 9):
            answer = 0
            break 
    print("#"+str(tc+1), answer)