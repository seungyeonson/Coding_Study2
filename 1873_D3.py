def direction(a):
    if a == '^':
        return 0
    elif a == '>':
        return 1
    elif a == 'v':
        return 2
    elif a == '<':
        return 3
    else: return -1

def turn(a):
    if a == 'U':
        return 0
    elif a == 'R':
        return 1
    elif a == 'D':
        return 2
    elif a == 'L':
        return 3
    elif a == 'S':
        return 4
    else: return -1

T = int(input())
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
tank = ['^', '>', 'v', '<']
for tc in range(T):
    H, W = map(int, input().split())
    arr = []
    car = []
    for i in range(H):
        arr.append(list(input()))
    N = int(input())
    order = list(input())
    for i in range(H):
        for j in range(W):
            if arr[i][j] in tank:
                car = [i, j, direction(arr[i][j])]
    for oo in order:
        # for i in range(len(arr)):
        #     for j in range(len(arr[i])):
        #         print(arr[i][j], end='')
        #     print("")
        # print("")
        # print(oo)
        #위로가라는 명령
        if turn(oo)!=4:
            x = car[0] +dr[turn(oo)]
            y = car[1] +dc[turn(oo)]
            if x < 0 or x>=H or y < 0 or y >=W or arr[x][y] == '#' or arr[x][y]=='*':
                car[2] = turn(oo)
                arr[car[0]][car[1]] = tank[car[2]]
                continue
            elif arr[x][y] == '.':
                arr[x][y] = tank[turn(oo)]
                arr[car[0]][car[1]] = '.'
                car[0] = x
                car[1] = y
                car[2] = turn(oo)
            else:
                #물이나 다른 경우
                car[2] = turn(oo)
                arr[car[0]][car[1]] = tank[car[2]]
                continue
        elif turn(oo) ==4:
            x = car[0]
            y = car[1]
            while(True):
                x += dr[car[2]]
                y += dc[car[2]]
                if x < 0 or x >= H or y < 0 or y >= W:
                    break;
                elif arr[x][y] == '#':
                    break;
                elif arr[x][y] == '*':
                    arr[x][y] = '.'
                    break;

    print("#"+str(tc+1),end=' ')
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            print(arr[i][j],end='')
        print("")
