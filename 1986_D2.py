'''
1986 D2
1부터 N까지 홀수는 더하고 짝수는 뺀다.
answer = 0
for i in range(1, N+1)
if i %2==0:
answer-=i
else:
answer+=i
'''
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    answer = 0
    for i in range(1,N+1):
        if i % 2==0:
            answer -= i
        else:
            answer += i
    print('#'+str(test_case),answer)