#!/bin/python3
import sys

S = input().strip()
try:
    num=int(S)
    print(num)
except Exception as e :
    print('Bad String')
