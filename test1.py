# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
dr = [0, -1, 0, 1]
dc = [1, 0, -1, 0]


# k =1 => start = 0,0 =>direction 0
# k =2 => start = 0,n-1 => direction 1
# k =3 => start = n-1,n-1 =>direction 2
# k =4 => start = n-1,0 => direction 3
def snail(arr, start, direction, n):
    x = start[0]
    y = start[1]
    cnt = 1
    arr[x][y] = cnt
    dx = x
    dy = y
    while True:
        if (cnt == n * n):
            break
        dx += dr[direction]
        dy += dc[direction]
        if (0 <= dx < n and 0 <= dy < n):
            if (arr[dx][dy] == 0):
                cnt += 1
                arr[dx][dy] = cnt
            else:
                dx -= dr[direction]
                dy -= dc[direction]
                direction = (direction + 1) % 4
        else:
            dx -= dr[direction]
            dy -= dc[direction]
            direction = (direction + 1) % 4

k, n = map(int, input().split())
arr = []
for i in range(n):
    arr.append([0] * n)
if k == 1:
    snail(arr, [0, 0], 0, n)
elif k == 2:
    snail(arr, [0, n - 1], 1, n)
elif k == 3:
    snail(arr, [n - 1, n - 1], 2, n)
elif k == 4:
    snail(arr, [n - 1, 0], 3, n)

for i in range(n):
    for j in range(n):
        print("\t" + str(arr[i][j]), end="")
    print()
