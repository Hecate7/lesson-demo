package perday.perday_0926_113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找出所有从根节点到叶子结点路径总和等于给定目标和的路径
 */
public class PathSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum){
        if (root == null){
//            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);

        //到达了叶子结点
        if (root.left == null && root.right == null){
            //满足条件
            if (root.val == sum){
                res.add(new ArrayList<>(list));
            }

            list.remove(list.size()-1);
            return;
        }

        dfs(root.left, sum-root.val);
        dfs(root.right, sum-root.val);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left  = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;

        PathSum pathSum = new PathSum();
        List<List<Integer>> lists = pathSum.pathSum(node1, 22);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
