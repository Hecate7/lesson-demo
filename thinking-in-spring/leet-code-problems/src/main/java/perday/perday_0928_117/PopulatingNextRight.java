package perday.perday_0928_117;

import common.Node;

public class PopulatingNextRight {
    Node last = null;
    Node nextStart = null;

    public Node connect1(Node root){
        if (root==null) return null;

        if (root.left!=null && root.right!=null){
            root.left.next = root.right;
        }
        if (root.left!=null && root.right==null){
            root.left.next = getNext(root.next);
        }
        if (root.right != null){
            root.right.next = getNext(root.next);
        }

        connect1(root.right);
        connect1(root.left);
        return root;
    }

    public Node getNext(Node root){
        if (root==null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        if (root.next != null) return getNext(root.next);
        return null;
    }

    public Node connect(Node root){
        if (root == null) return null;

        Node start = root;
        while (start != null){
            last = null;
            nextStart = null;
            for (Node p=start; p!=null; p=p.next){
                if (p.left != null){
                    handle(p.left);
                }
                if (p.right != null){
                    handle(p.right);
                }
            }
            start = nextStart;
        }

        return root;
    }

    public void handle(Node p){
        if (last != null){
            last.next = p;
        }

        if (nextStart == null){
            nextStart = p;
        }
        last = p;
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(7);
//        Node node7 = new Node(7);
//        Node node8 = new Node(2);
//        Node node9 = new Node(5);
//        Node node10 = new Node(1);

//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;
//        node4.left  = node7;
//        node4.right = node8;
//        node6.left = node9;
//        node6.right = node10;

        PopulatingNextRight nextRight = new PopulatingNextRight();
        Node node = nextRight.connect1(node1);
        System.out.println(node);
    }
}
