#z
N, i, j = map(int,input().split())
temp = 0
while N>=1:
    if 0<=i<2**N//2 and 0<=j<2**N//2:
        temp +=0
    elif 0<=i<2**N//2 and 2**N//2<=j<2**N:
        temp += (2**N)*(2**N)*1//4
        j -= 2**N//2
    elif 2**N//2<=i<2**N and 0<=j<2**N//2:
        temp += (2**N)*(2**N)*2//4
        i -= 2**N//2
    elif 2**N//2<=i<2**N and 2**N//2<=j<2**N:
        temp += (2**N)*(2**N)*3//4
        i -= 2 ** N // 2
        j -= 2 ** N // 2
    N = N-1
print(temp)