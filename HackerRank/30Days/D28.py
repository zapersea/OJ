#!/bin/python3
import sys

N = int(input().strip())
L=[]
for a0 in range(N):
    firstName,emailID = input().strip().split(' ')
    firstName,emailID = [str(firstName),str(emailID)]
    if emailID.find('@gmail.com')!=-1 :
        L.append(firstName)
L.sort()
for tmp in L:
    print(tmp)
