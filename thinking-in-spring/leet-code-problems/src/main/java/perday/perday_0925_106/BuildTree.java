package perday.perday_0925_106;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        List inList = new ArrayList();
        List postList = new ArrayList();
        for (int i = 0; i < inorder.length; i++) {
            inList.add(inorder[i]);
        }
        for (int i = 0; i < postorder.length; i++) {
            postList.add(postorder[i]);
        }
        return buildNode(inList, postList);
    }

    private TreeNode buildNode(List<Integer> inorder, List<Integer> postorder){
        if (inorder.size() == 1){
            return new TreeNode(inorder.get(0));
        }

        int midIndex = getMidIndex(inorder, postorder);
        int val = postorder.get(midIndex);
        TreeNode node = new TreeNode(val);
        node.left = buildNode(inorder.subList(0, inorder.indexOf(val)), postorder);
        node.right = buildNode(inorder.subList(inorder.indexOf(val)+1, inorder.size()),postorder);
        return node;
    }

    private int getMidIndex(List<Integer> inorder, List<Integer> postorder){
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < inorder.size(); i++) {
            MAX = Math.max(MAX, postorder.indexOf(inorder.get(i)));
        }
        return MAX;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = buildTree.buildTree(inorder, postorder);
        System.out.println(node.toString());
    }
}
