package com.tree;

import java.util.Queue;

/**
 * @author dzl
 * 2020/11/6 10:14
 * @Description
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
        binarySortTree.delNode(7);
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
    }
}

class BinarySortTree {
    private Node root;

    public BinarySortTree() {
    }

    public void infixOrder() {
        if (root != null)
            root.infixOrder();
    }

    /**
     * 二叉查找树--->  left < root and right > root
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 删除结点
     * 1.通过value值找到target
     * 2.如果未找到，就返回空
     * 3.如果找到了，就去找它的父子结点。
     * 三种情况，target 没有子树 有一个子树  有两个子树
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null)
            return;
        Node target = search(value);
        if (target == null)
            return;
        if (root.getRight() == null && root.getLeft() == null) {
            root = null;
            return;
        }
        Node parent = searchParent(target);
        if (target.getLeft() == null && target.getRight() == null) {
            if (parent.getLeft() != null) {
                if (parent.getLeft() == target) {
                    parent.setLeft(null);
                }
            }
            if (parent.getRight() != null) {
                if (parent.getRight() == target) {
                    parent.setRight(null);
                }
            }
        } else if (target.getLeft() != null && target.getRight() != null) {
            int temp = searchRightMin(target.getRight());
            target.setValue(temp);
        } else {
            if (target.getLeft() != null) {
                if (parent != null) {
                    if (parent.getLeft() == target) {
                        parent.setLeft(target.getLeft());
                    } else {
                        parent.setRight(target.getLeft());
                    }
                } else {
                    root = target.getLeft();
                }
            } else {
                if (parent != null) {
                    if (parent.getLeft() == target) {
                        parent.setLeft(target.getRight());
                    } else {
                        parent.setRight(target.getRight());
                    }
                } else {
                    root = target.getRight();
                }
            }
        }

    }

    /**
     * 找到最小值并且删除该对象
     *
     * @param right
     * @return
     */
    private int searchRightMin(Node right) {
        Node parent = right, node = right.getLeft();
        while (node != null && node.getLeft() != null) {
            parent = node;
            node = parent.getLeft();
        }
        parent.setLeft(null);
        return node.getValue();
    }

    private Node search(int value) {
        if (root != null) {
            return root.search(value);
        }
        return null;
    }

    private Node searchParent(Node target) {
        if (root == null) {
            return null;
        }
        return root.searchParent(target);
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public void infixOrder() {

        if (this.left != null)
            this.left.infixOrder();
        System.out.println(this);
        if (this.right != null)
            this.right.infixOrder();
    }

    /**
     * 二叉查找树--->  left < root and right > root
     *
     * @param node 添加结点的方法
     */
    public void add(Node node) {
        if (node == null)
            return;
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }


    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (this.left != null)
                return this.left.search(value);
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
        }
        return null;
    }


    public Node searchParent(Node target) {
        if (this.value > target.value) {
            if (this.left != null) {
                if (this.left == target) {
                    return this;
                }
                return this.left.searchParent(target);
            }

        } else {
            if (this.right != null) {
                if (this.right == target) {
                    return this;
                }
                return this.right.searchParent(target);
            }
        }
        return null;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
