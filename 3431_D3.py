'''
3431 D3
T: 테스트 케이스 개수
L, U, X : 최소운동분, 최대 운동분, 이번 운동분
answer = 0
#먼저 운동을 부족하게 한경우
if X<L:
answer = L-X
elif L<=X<=U:
answer = 0
elif X>U:
answer = -1
'''
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # N = int(input())
    answer = 0
    L, U, X = map(int, input().split())
    if X < L:
        answer = L - X
    elif L <= X <= U:
        answer = 0
    elif X >= U:
        answer = -1
    print('#'+str(test_case),answer)

