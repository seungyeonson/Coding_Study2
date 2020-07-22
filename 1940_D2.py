T = int(input())
for tc in range(T):

    N = int(input())
    answer = 0
    v = 0
    for i in range(N):
        temp = input()

        c = temp[0]
        if c != 0:
            a = int(temp[-1])

        if c == '0':
            pass
        elif c == '1':
            v = v + a
        elif c == '2':
            v = v - a
            if v <= 0:
                v = 0
        answer += v
    print("#"+str(tc+1),answer)