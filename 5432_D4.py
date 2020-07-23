T = int(input())
for tc in range(T):
    answer = 0
    stick = list(input())
    left = 0
    stack = []
    for i in range(len(stick)):
        if len(stack) == 0:
            stack.append(i)
            if stick[i] == '(':
                left += 1
        elif stick[i] == ')':
            if stick[i - 1] == ')':
                left -= 1
                stack.pop()
                answer += 1
                continue

            if left == 1:
                left -= 1
                stack.pop()
            else:
                left -= 1
                answer += left
                stack.pop()

        elif stick[i] == '(':
            left += 1
            stack.append(i)
    print("#"+str(tc+1),answer)