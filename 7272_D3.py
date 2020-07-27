T = int(input())
for tc in range(1,T+1):
    answer = True
    glass = []
    glass.append(list('CEFGHIJKLMNSTUVWXYZ'))
    glass.append(list('ADOPQR'))
    glass.append(list('B'))
    A, B = input().split()


    for i in range(len(A)):
        if len(A) != len(B):
            answer = False
            break
        for j in glass:
            if A[i] in j:
                if B[i] in j:
                    answer = True
                    continue
                elif B[i] not in j:
                    answer = False
                    break
            else:
                if B[i] not in j:
                    continue
                elif B[i] in j:
                    answer = False
                    break
        if answer == False:
            break

    print("#"+str(tc),'SAME' if answer else 'DIFF')