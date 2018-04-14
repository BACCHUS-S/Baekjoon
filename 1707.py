from sys import stdin
for _ in range(int(input())):
    N,M=map(int,stdin.readline().split())
    L=[[]]*N
    T=[0]*N #방문 했는 지 안했는 지
    C=[-1]*N #1 아니면 0으로 색칠 하겠소!!
    #print(L, T, C)
    for i in range(M):
        a,b=map(int,stdin.readline().split())
        if not L[a-1]:
            L[a-1]=[b-1]
            #print('L1 :', L)
        else:
            L[a-1].append(b-1)
            #print('L2 :', L)
        if not L[b-1]:
            L[b-1]=[a-1]
            #print('L3 :', L)
        else:
            L[b-1].append(a-1)
            #print('L4 :', L)
    st=[]
    no=False
    for i in range(N):
        if no:
            break
        if T[i]==0:
            st.append(i)
            #print('st : ', st)
            T[i]=1
            C[i]=0
        while st:
            c=st.pop()
            #print('c : ', c)
            for j in L[c]:
                #print('j :', j)
                if T[j]==0:
                    st.append(j)
                    T[j]=1
                    C[j]=(C[c]+1)%2
                    #print('T, C :', T, C)
                if T[j]==1:
                    #print('T, C :', T, C)
                    if C[j]==C[c]:
                        no=True
                        break
    if no:
        print("NO")
    else:
        print("YES")
