a,b,c=[int(temp) for temp in input().strip().split()]
ans=1
N=b
while b>0:
    if b%2==1:
        ans=(ans*a)%c
    b=b//2
    a=(a*a)%c  #这里也要%c，否则无法通过
print(ans)
