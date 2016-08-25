N,P=[int(temp) for temp in input().strip().split()]
S=1;
for i in range(2,N+1):
    S*=i
print(S%P)
