package perday.perday_0930_701;

import common.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val){
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val){
        if (val < root.val){
            if (root.left == null){
                root.left = new TreeNode(val);
                return;
            }
            insert(root.left, val);
        } else {
            if (root.right == null){
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        }
    }
}
