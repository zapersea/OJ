rd=[int(temp) for temp in input().strip().split()]
ed=[int(temp) for temp in input().strip().split()]
if rd[2]>ed[2]:
    sum=10000
elif rd[2]<ed[2]:
    sum=0
else:
    if rd[1]>ed[1]:
        sum=500*(rd[1]-ed[1])
    elif rd[1]<ed[1]:
        sum=0
    else:
        if rd[0]>ed[0]:
             sum=15*(rd[0]-ed[0])
        else:
             sum=0
print(sum)
