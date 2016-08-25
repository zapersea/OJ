class Node():
    def __init__ (self,data):
        self.data=data
        self.left=None
        self.right=None

def getHeight(root):
    if root ==None:
        return -1
    else:
        leftH=getHeight(root.left)
        rightH=getHeight(root.right)
        return 1+(leftH if leftH>rightH else rightH)

def insert(root,data):
    if root==None:
        return Node(data)
    else:
        if data<=root.data:
            cur=insert(root.left,data)
            root.left=cur
        else:
            cur=insert(root.right,data)
            root.right=cur
        return root
            
Num=int(input())
root = None
for i in range(0,Num):
    data=int(input())
    root=insert(root,data)
height=getHeight(root)
print(height)
