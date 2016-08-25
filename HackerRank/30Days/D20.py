#!/bin/python3
import sys

def  swap(a,j):
    temp=a[j]
    a[j]=a[j+1]
    a[j+1]=temp
    
def  bubbleSort(n,a):
    allSwaps =0
    for i in range(0,n):
        numberOfSwaps=0;
        for j in range(0,n-1):
            if a[j] > a[j+1]:
                swap(a,j)
                numberOfSwaps+=1
        allSwaps+=numberOfSwaps
        if numberOfSwaps ==0:
            break
    return allSwaps

n = int(input().strip())
a = [int(a_temp) for a_temp in input().strip().split(' ')]
allSwaps  = bubbleSort(n,a);
print("Array is sorted in "+str(allSwaps)+" swaps.");
print("First Element: "+str(a[0]));
print("Last Element: "+str(a[n-1]));
