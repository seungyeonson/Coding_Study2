T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    answer_1 = 0
    answer_2 = 0
    a, b = map(int, input().split())
    answer_1 = int(a//b)
    answer_2 = a % b
        
    print('#'+str(test_case),answer_1,answer_2)