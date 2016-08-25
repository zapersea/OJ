N =int(input())
maxsum=0
cur=0
for i in range(N):
    cur+=int(input())
    if cur>maxsum:
        maxsum=cur
    if cur<0:
        cur=0
print(maxsum)
