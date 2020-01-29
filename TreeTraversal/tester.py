# User enters an expression 2 + 5 * 3 + 1^6 - 7
# No parentheses
# Spaces will separate numbers
# Create a tree
# Do a Preorder and Postorder traversal of the tree
# Print out tree for Preorder and Postorder and the answer for in order


# def split(input):
#     expression = input
#     characters = expression.split(" ", len(expression))
#     return characters

class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
        self.operator = False

def isOperator(c):
    if c == '+' or c == '-' or c == '*' or c == '/' or c == '**':
        return True
    else:
        return False


def makeTree(expression):
    stack = []

    for character in expression:
        if not isOperator(character):
            t = Node(character)
            stack.append(t)
        else:
            t = Node(character)
            t1 = stack.pop()
            t2 = stack.pop()

            t.right = t1
            t.left = t2

            stack.append(t)

    t = stack.pop()
    return t

    # def insert(self, data):
    #     if self.data:
    #         if data < self.data:
    #             self.left = Node(data)
    #         else:
    #             self.left.insert(data)
    #     elif data > self.data:
    #         if self.right is None:
    #             self.right = Node(data)
    #         else:
    #             self.right.insert(data)
    #     else:
    #         self.data = data
    #
    # def isOperator(c):
    #     if c == '+' or c == '-' or c == '*' or c == '/' or c == '**':
    #         return True
    #     else:
    #         return False
    #
    # def preorderTraversal(self, root):
    #     result = []
    #     if root:
    #         result.append(root.data)
    #         result = result + self.preorderTraversal(root.left)
    #         result = result + self.preorderTraversal(root.right)
    #     return result


if __name__ == '__main__':

    print("Please type expression with no parentheses")
    print("Separate numbers & operators with spaces")
    print("Example: 2 + 5 * 3 + 1 ^ 6 - 7")
    expression = input()
    r = makeTree(expression.replace(" ",""))

