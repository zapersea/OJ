T = int(input())
for i in range(T):
    K = int(input().strip().split()[1])
    L =[int(temp) for temp in input().strip().split()]
    count=0
    for i in L:
        if i<=0:
            count+=1
    if count <K:
        print("YES")
    else :
        print("NO")
