package com.lj.algs4.select;


import java.util.Random;

/**
 * Created by lijing on 2017/12/28.
 */
public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root;

    public void put(K key, V value) {
        //  put(new Node(key, value));

        if (this.root == null) {
            initRoot(new Node(key, value));
        }
        put(root, new Node(key, value));
    }

    public void show(Node root, StringBuilder sb) {

        if (root == null) return;
        sb.append(root.key + " ");
        show(root.left, sb);
        show(root.right, sb);


    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BinarySearchTree : ");
        show(root, sb);
        return sb.toString();
    }

    public void put(Node node) { //采用循环的方式插入
        if (root == null) {
            initRoot(node);
        }
        if (node == null) { //插入值不为空
            throw new RuntimeException();
        }
        Node temp = root;
        while (true) {
            if (temp.key.compareTo(node.key) < 0) { //当前节点的值比key值小，放在右边
                if (temp.right != null) {
                    temp = temp.right;
                    continue;
                }
                temp.right = node;
                break;
            } else if (temp.key.compareTo(node.key) > 0) {
                if (temp.left != null) {
                    temp = temp.left;
                    continue;
                }
                temp.left = node;
                break;
            } else if (temp.key.compareTo(node.key) == 0) {
                temp.value = node.value;
                break;
            }
            break;
        }

    }

    public void put(Node root, Node node) {

        int cmp = node.key.compareTo(root.key);
        if (cmp < 0) {
            if (root.left != null) {
                put(root.left, node);
            } else {
                root.left = node;
                return;
            }
        }
        if (cmp > 0) {
            if (root.right != null) {
                put(root.right, node);
            } else {
                root.right = node;
                return;
            }
        }
        if (cmp == 0) {
            root.value = node.value;
        }
    }

    public void remove(K key) {
        if (root == null) return;
        if (key == null) throw new RuntimeException();
        remove(root, root, key);
    }

    public void remove(Node root, Node parent, K key) {
        int cmp = root.key.compareTo(key);
        if (cmp > 0) {
            remove(root.left, root, key);
        }
        if (cmp < 0) {
            remove(root.right, root, key);
        }
        if (cmp == 0) {
            Node min = minNode(root, true);
            if(min.key!=root.key){
                min.right = root.right;
                min.left = root.left;
            }
            else{
                if(min.right!=null) {
                    min = minNode(min.right, true);
                }else{
                    min=null;
                }
            }
            if (parent.left.key == root.key) {
                parent.left = min;
            } else if (parent.right.key == root.key) {
                parent.right = min;
            }
            return;
        }
    }

    public Node minNode(Node root, boolean isDelete) {
        while (root.left != null) {
            root = root.left;
        }
        Node min = root;
        if (isDelete) {
            root = null;
        }
        return min;
    }

    public Node maxNode(Node root, boolean isDelete) {
        while (root.right != null) {
            root = root.right;
        }
        Node max = root;
        if (isDelete) {
            root.right = null;
        }
        return max;
    }

    public V get(K key) {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (true) {
            if (temp == null) {
                return null;
            }
            if (temp.key.compareTo(key) < 0) {
                temp = temp.right;
                continue;
            }
            if (temp.key.compareTo(key) > 0) {
                temp = temp.left;
                continue;
            }
            if (temp.key.compareTo(key) == 0) {
                return temp.value;
            }
            break;
        }
        return null;
    }

    public void initRoot(Node node) {
        this.root = node;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return "key : "+key+" value : "+value;
        }
    }

    public static void main(String args[]) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Integer[] a = new Integer[20];
        Random random = new Random(47);
        for (int i = 0; i < a.length; i++) {
            Integer temp = random.nextInt(50);
            a[i] = temp;
            binarySearchTree.put(temp, random.nextInt(41));
        }
        System.out.println(binarySearchTree.toString());
        System.out.println(binarySearchTree.get(a[10]));
        binarySearchTree.remove(a[10]);
        System.out.println(binarySearchTree.toString());
        System.out.println(binarySearchTree.maxNode(binarySearchTree.root,false).toString());
    }
}
