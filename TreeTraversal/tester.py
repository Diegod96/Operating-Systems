# User enters an expression 2 + 5 * 3 + 1^6 - 7
# No parentheses
# Spaces will separate numbers
# Create a tree
# Do a Preorder and Postorder traversal of the tree
# Print out tree for Preorder and Postorder and the answer for in order

# https://www.tutorialspoint.com/python_data_structure/python_tree_traversal_algorithms.htm
# https://mkyong.com/python/python-how-to-split-a-string/

class Node:

    def __init__(self, value):
        self.left = None
        self.right = None
        self.data = value

    def insert(self, data):
        if self.data:
            if data < self.data:
                self.left = Node(data)
            else:
                self.left.insert(data)
        elif data > self.data:
            if self.right is None


    def isOperator(c):
        if c == '+' or c == '-' or c == '*' or c == '/' or c == '^':
            return True
        else:
            return False

    def preorderTraversal(self, root):
        result = []
        if root:
            result.append(root.data)
            result = result + self.preorderTraversal(root.left)
            result = result + self.preorderTraversal(root.right)
        return result
