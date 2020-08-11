def find(arr, pp, N):
    #key가 dictionary에 포함됬는지 검사
    if pp in arr:
        return arr[pp]

    else :
        return dogam1[pp]

N, M = map(int, input().split())
dogam = dict()
dogam1 = dict()
for i in range(1, N + 1):
    name = input()
    dogam[str(i)] = name
    dogam1[name]=str(i)
problem=[]
for i in range(M):
    problem.append(input())
for i in range(M):
    print(find(dogam, problem[i], N))