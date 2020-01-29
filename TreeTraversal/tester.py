# User enters an expression 2 + 5 * 3 + 1^6 - 7
# No parentheses
# Spaces will separate numbers
# Create a tree
# Do a Preorder and Postorder traversal of the tree
# Print out tree for Preorder and Postorder and the answer for in order

class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data

    def split(self):
        expression = "2 + 6 * 3 + 1 ^ 6 - 7"
        data = expression.split(" ", 2)
        for character in data:
            print(character)

    def insert(self, data):
        if self.data:
            if data < self.data:
                self.left = Node(data)
            else:
                self.left.insert(data)
        elif data > self.data:
            if self.right is None:
                self.right = Node(data)
            else:
                self.right.insert(data)
        else:
            self.data = data


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


if __name__ == '__main__':
    expression = "2 + 6 * 3 + 1 ^ 6 - 7"
    data = expression.split(" ", len(expression))
    for character in data:
        print(character)
