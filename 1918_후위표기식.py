from collections import deque
operator = ['+','*','-','/']
operDict = {'+' : 1, '-' : 1, '*' : 2, '/' : 2, '(' : 0}
STACK,ANS = deque(), deque()
for item in input():
    if item =="(": STACK.append(item)
    elif item==")":
        while STACK:
            top = STACK.pop()
            if top=="(":break
            else: ANS.append(top)
    elif item in operator:
        while STACK and operDict[STACK[-1]]>= operDict[item]:
            ANS.append(STACK.pop())
        STACK.append(item)
    else: ANS.append(item)
while STACK: ANS.append(STACK.pop())
print(''.join(ANS))



"""
depth = 0
preIndex=-1
for item in input():
    if item=="(": depth+=1
    elif item ==")":
        depth -= 1
        ANS.append(OPER.pop()[0])
    elif item in operator:
        curIndex=operator.index(item)%2
        if curIndex>preIndex: OPER.append([item,curIndex,depth])
        else:
            while OPER:
                tempItem, tempIdx, tempDepth = OPER.pop()
                if tempIdx<curIndex:
                    OPER.append([tempItem,tempIdx])
                    break
                ANS.append(tempItem)
            OPER.append([item,curIndex])
        preIndex = curIndex
    else:
        ANS.append(item)
    #print(''.join(ANS), OPER)
while OPER: ANS.append(OPER.pop()[0])
print(''.join(ANS))
"""