#경비원
W, H = map(int, input().split())
N = int(input())
arr = []
answer = 0
Distance = []
for i in range(N):
    Distance.append(list(map(int, input().split())))
D, S = map(int, input().split())
for d, s in Distance:
    if d == D:
        answer += abs(S-s)
    elif d in [1, 2] and D in [1, 2]:
        answer += min(s+H+S, W-s+H+W-S)
    elif d in [4, 3] and D in [3, 4]:
        answer += min(s+W+S, H-s+W+H-S)
    elif d in [1, 3] and D in [1, 3]:
        answer += s+S
    elif d in [2, 3] and D in [3, 2]:
        if d==3:
            answer += H-s+S
        else:
            answer += H-S+s
    elif d in [1, 4] and D in [1, 4]:
        if d == 1:
            answer += W - s + S
        else:
            answer += W - S + s
    elif d in [4, 2] and D in [2, 4]:
        answer += H-S+W-s
print(answer)