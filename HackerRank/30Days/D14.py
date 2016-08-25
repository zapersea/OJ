class Difference:
    def __init__(self, a):
        self.__elements = a
# Add your code here
    def computeDifference(self):
        self.maximumDifference=0
        for i in range(0,len(self.__elements)-1):
            for j in range(i+1,len(self.__elements)):
                tmp=abs(self.__elements[i]-self.__elements[j])
                if tmp > self.maximumDifference :
                    self.maximumDifference = tmp
                
        

# End of Difference class

_ = input()   # useless
a = [int(e) for e in input().split(' ')]
d = Difference(a)
d.computeDifference()
print(d.maximumDifference)
