a,b=[int(tmp) for tmp in input().strip().split()]
x,y=a,b
c=b%a
while c!=0:
    b,a=a,c
    c=b%a
print(x*y//a)
