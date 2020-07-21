'''
1945
T : 테스트케이스 개수
N : 숫자
numbers = [2,3,5,7,11]
answer = [0]*5
for i in range(numbers)
while(N%numbers[i]==0)
	answer[i]+=1
	N = N//i
'''
#sys.stdin = open("input.txt", "r")

T = int(input())
numbers = [2,3,5,7,11]
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    answer = [0]*5
    for i in range(len(numbers)):
        while(N % numbers[i]==0):
            answer[i]+=1
            N = N//numbers[i]
    print('#'+str(test_case),*answer,sep=' ')
    # ///////////////////////////////////////////////////////////////////////////////////