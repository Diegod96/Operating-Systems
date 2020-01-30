# User enters an expression 2 + 5 * 3 + 1 ^ 6 - 7
# No parentheses
# Spaces will separate numbers
# Create a tree
# Do a Preorder and Postorder traversal of the tree
# Print out tree for Preorder and Postorder and the answer for in order


# def split(input):
#     expression = input
#     characters = expression.split(" ", len(expression))
#     return characters


class Stack(object):
    def __init__(self):
        self.stack = []

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        return self.stack.pop()

    def peek(self):
        return self.stack[-1]

    def is_empty(self):
        return len(self.stack) == 0


class Node(object):
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.data)


class Tree(object):
    def __init__(self):
        self.root = None

    def insert(self, val):
        new_node = Node(val)
        if self.root == None:
            self.root = new_node
        else:
            current = self.root
            parent = self.root
            while current is not None:
                parent = current
                if val < current.data:
                    current = current.lchild
                else:
                    current = current.rchild
            if val < parent.data:
                parent.lchild = new_node
            else:
                parent.rchild = new_node

    def createTree(self, expr):
        stack = Stack()
        operators = ['+', '-', '*', '/', '^']
        tokens = expr.split()
        current = Node(None)
        self.root = current
        for t in tokens:
            if t == '(':
                new_node = Node(None)
                current.lchild = new_node
                stack.push(current)
                current = current.lchild
            elif t == ')':
                if not stack.is_empty():
                    current = stack.pop()
                else:
                    return
            elif t in operators:
                current.data = t
                stack.push(current)
                new_node = Node(None)
                current.rchild = new_node
                current = current.rchild
            else:
                current.data = t
                current = stack.pop()

    def preOrder(self, aNode):
        if aNode is not None:
            print(aNode, end=' ')
            self.preOrder(aNode.lchild)
            self.preOrder(aNode.rchild)

    def postOrder(self, aNode):
        if aNode is not None:
            self.postOrder(aNode.lchild)
            self.postOrder(aNode.rchild)
            print(aNode, end=' ')

if __name__ == '__main__':
    expression = input()
    tree = Tree()
    tree.createTree(expression)
    print('Prefix Expression: ', end=' ')
    tree.preOrder(tree.root)
    print('Postfix Expression:', end=' ')
    tree.postOrder(tree.root)


# class Node:
#
#     def __init__(self):
#         self.left = None
#         self.right = None
#         self.data = data
#
#     def splitExpression(self):
#         x = []
#         expression = input()
#         expression = expression.replace(" ", "")
#         for character in expression:
#             x.append(character)
#         return x
#
#     def insert(self, data):
#         if self.data:
#             if data < self.data:
#                 self.left = Node(data)
#             else:
#                 self.left.insert(data)
#         elif data > self.data:
#             if self.right is None:
#                 self.right = Node(data)
#             else:
#                 self.right.insert(data)
#         else:
#             self.data = data
#
#     def isOperator(c):
#         if c == '+' or c == '-' or c == '*' or c == '/' or c == '**':
#             return True
#         else:
#             return False


# def makeTree(expression):
#     stack = []
#
#     for character in expression:
#         if not isOperator(character):
#             t = Node(character)
#             stack.append(t)
#         else:
#             t = Node(character)
#             t1 = stack.pop()
#             t2 = stack.pop()
#
#             t.right = t1
#             t.left = t2
#
#             stack.append(t)
#
#     t = stack.pop()
#     return t


# def preorderTraversal(self, root):
#     result = []
#     if root:
#         result.append(root.data)
#         result = result + self.preorderTraversal(root.left)
#         result = result + self.preorderTraversal(root.right)
#     return result


# if __name__ == '__main__':
#     print("Please type expression with no parentheses")
#     print("Separate numbers & operators with spaces")
#     print("Example: 2 + 5 * 3 + 1 ^ 6 - 7")
