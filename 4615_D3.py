T = int(input())
dr = [-1, -1, -1, 0, 0, 1, 1, 1]
dc = [-1, 0, 1, -1, 1, -1, 0, 1]
for tc in range(T):
    answer_B = 2
    answer_W = 2
    N, M = map(int, input().split())
    arr = []
    for i in range(N+1):
        arr.append([0]*(N+1))
    arr[N//2][N//2] = 2
    arr[N//2][N//2+1] = 1
    arr[N//2+1][N//2] = 1
    arr[N//2+1][N//2+1] = 2

    for i in range(M):
        x, y, d = map(int, input().split())
        if d == 1:
            arr[x][y] = 1
            answer_B+=1
        else:
            arr[x][y] = 2
            answer_W+=1
        for j in range(8):
            dx = x + dr[j]
            dy = y + dc[j]
            if(0 < dx <= N) and (0 < dy <= N):
                if arr[dx][dy] == 0:
                    continue
                elif arr[dx][dy] == d:
                    continue
                elif arr[dx][dy] != d:
                    flag = True
                    temp = []
                    while flag:
                        temp.append([dx,dy])
                        dx = dx + dr[j]
                        dy = dy + dc[j]
                        if (dx<1 or dx>N or dy<1 or dy > N) or arr[dx][dy] == 0:
                            flag = False;
                        elif arr[dx][dy] == d:
                            for k in range(len(temp)):
                                if d == 1:
                                    arr[temp[k][0]][temp[k][1]] = 1
                                    answer_W -= 1
                                    answer_B += 1
                                elif d == 2:
                                    arr[temp[k][0]][temp[k][1]] = 2
                                    answer_B -= 1
                                    answer_W += 1
                            break
                        elif arr[dx][dy] != d:
                            continue
            else:
                continue
    print("#"+str(tc+1),answer_B,answer_W)