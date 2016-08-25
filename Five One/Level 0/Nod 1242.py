n=int(input().strip())
last=1
cur=1
mod=1000000009
for i in range(n-2):
    temp=last
    last=cur
    cur=(cur+temp)%mod
print(cur,end=' ')
