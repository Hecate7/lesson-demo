package perday.perday_0926_113.prepare;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    /**
     * 深度优先搜索-走迷宫
     * 深度优先搜索使用的时回溯思想
     *
     * 时间复杂度：每条边最多会被访问两遍（遍历+回溯）， 时间复杂度为O(E)
     * 空间复杂度为O(V)
     * 递归回溯-借用栈实现
     */

    Graph.adjacencyList graph;
    boolean found = false;

    public void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[graph.v];
        int[] prev = new int[graph.v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        recureDfs(s, t, visited, prev);

    }

    private void recureDfs(int w, int t, boolean[] visited, int[] prev){
        if (found == true) return;

        visited[w] = true;
        if (w == t){
            found = true;
            return;
        }

        for (int i = 0; i < graph.adj[w].size(); i++) {
            int q = graph.adj[w].get(i);
            if (!visited[q]){
                prev[q] = w;
                recureDfs(q, t, visited, prev);
            }
        }
    }


    /**
     * 二叉树的深度优先遍历
     */

    private List<Integer> res = new ArrayList<>();

    /**
     * 递归实现-根节点->左子树->右子树
     * @param root
     */
    private void dfsTree_recursion(TreeNode root){
        if (root == null) return;

        res.add(root.val);
        dfsTree_recursion(root.left);
        dfsTree_recursion(root.right);
    }

    /**
     * 非递归实现-stack记录右子树结点（先进后出）
     * @param root
     */
    private void dfsTree(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null){
            res.add(current.val);
            if (current.right != null){
                stack.push(current.right);
            }

            current = current.left;
            if (current == null && !stack.isEmpty()){
                current = stack.pop();
            }
        }
    }
}
