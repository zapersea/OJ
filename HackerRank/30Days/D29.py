#!/bin/python3
import sys

t = int(input().strip())
for a0 in range(t):
    n,k = input().strip().split()
    n,k = [int(n),int(k)]
    maxand=0
    for i in range(1,n):
        for j in range(i+1,n+1):
            tmp=i&j
            if tmp>maxand and tmp<k:
                maxand=tmp
            if tmp==k-1:
                break
    print(maxand)
            
