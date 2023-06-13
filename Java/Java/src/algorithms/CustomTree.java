package algorithms;

import java.awt.*;

public class CustomTree<T extends Comparable<T>> {
    private Node root;

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value, Color.black);
            return true;
        }
        return addNode(root, value);
    }

    public boolean addNode(Node currentNode, T value) {
        if (currentNode.value == value) {
            return false;
        }
        if (currentNode.value.compareTo(value) > 0) {
            if (currentNode.left != null) {
                boolean result = addNode(currentNode.left, value);
                currentNode.left = rebalanced(currentNode.left);
                return result;
            } else {
                currentNode.left = new Node(value, Color.red);
                return true;
            }
        } else {
            if (currentNode.right != null) {
                boolean result = addNode(currentNode.right, value);
                currentNode.right = rebalanced(currentNode.right);
                return result;
            } else {
                currentNode.right = new Node(value, Color.red);
                return true;
            }
        }
    }

    public boolean contain(T value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value.compareTo(value) == 0) {
                return true;
            }
            if (currentNode.value.compareTo(value) > 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public boolean remove(T value) {
        if (!contain(value)) {
            return false;
        }

        Node deleteNode = root;
        while (deleteNode != null) {
            if (deleteNode.value.compareTo(value) == 0) {
                if (deleteNode.right == null && deleteNode.left == null) {
                    deleteNode = null;
                } else if (deleteNode.right == null) {
                    deleteNode.left.color = deleteNode.color;
                    deleteNode.value = deleteNode.left.value;
                    deleteNode.right = deleteNode.left.right;
                    deleteNode.left = deleteNode.left.left;
                    deleteNode = rebalanced(deleteNode);
                } else {
                    Node replaceNode = deleteNode.right;
                    Node preplaceNode = deleteNode;
                    while (replaceNode.left != null) {
                        preplaceNode = replaceNode;
                        replaceNode = replaceNode.left;
                    }
                    deleteNode.value = replaceNode.value;
                    if (replaceNode == preplaceNode) {
                        deleteNode.right = null;
                    } else {
                        preplaceNode.left = null;
                    }
                    deleteNode = rebalanced(deleteNode);
                    return true;
                }
                return true;
            }
            if (deleteNode.value.compareTo(value) > 0) {
                deleteNode = deleteNode.left;
            } else {
                deleteNode = deleteNode.right;
            }
        }
        return false;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.red;
        return left;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.red;
        return right;
    }

    private Node rebalanced(Node node) {
        Node result = node;
        boolean needRebalanced;
        do {
            needRebalanced = false;
            if (result.right != null && result.right.color == Color.red &&
                    (result.left == null || result.left.color == Color.black)) {
                needRebalanced = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.red &&
                    result.left.left != null && result.left.left.color == Color.red) {
                needRebalanced = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.red &&
                    result.right != null && result.right.color == Color.red) {
                needRebalanced = true;
                colorSwap(result);
            }
        } while (needRebalanced);
        return result;
    }

    private class Node {
        private T value;
        private Node left;
        private Node right;
        private Color color;

        public Node() {
            value = null;
            left = null;
            right = null;
            color = null;
        }

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
            color = null;
        }

        public Node(T value, Color color) {
            this.value = value;
            left = null;
            right = null;
            this.color = color;
        }
    }
}
