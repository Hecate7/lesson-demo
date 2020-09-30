package perday.perday_0926_113.prepare;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    Graph.adjacencyList graph;

    /**
     * 图的广度优先搜索算法
     * 先找离起始顶点最近的,然后是次近的,以此往外搜索
     *
     * 时间复杂度：最坏情况下，t距离s需要遍历整个图才能找到。每个顶点都要进出queue队列，每个边都被访问一次。时间复杂度为O(V+E)
     *
     * 借用队列实现
     */


    /**
     * @param s 起始顶点
     * @param t 终点
     */
    public void bfs(int s, int t){
        if (s==t) return;
        //记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[graph.v];
        //存储已经被访问，但相连的顶点还没被访问的顶点
        //广度搜索-逐层访问，只有把第K层的顶点都访问完成，才能访问第K+1层顶点。记录第K层顶点
        LinkedList<Integer> queue = new LinkedList<>();
        //记录搜索路径。prev[w]记录顶点w是从哪个前驱顶点遍历来的
        int[] prev = new int[graph.v];
        for (int i = 0; i < prev.length; i++) {
            prev[i]=-1;
        }

        visited[s] = true;
        queue.add(s);
        //起始顶点
        while (queue.size() != 0){
            //w-当前搜索结点
            int w = queue.poll();
            //graph.adj[w]-当前结点指向的顶点List
            for (int i = 0; i < graph.adj[w].size(); i++) {
                //q-当前顶点指向的下一层顶点
                int q = graph.adj[w].get(i);
                if (!visited[q]){
                    //w->q, prev[q]=w
                    prev[q] = w;
                    //到达目标顶点
                    if (q == t){
                        print(prev, s, t);
                        return;
                    }
                    //未到达目标结点，标记q为已被访问
                    visited[q] = true;
                    //添加第K层顶点q到queue中，便于访问第K+1层顶点
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t){
        if (prev[t] != -1 && t != s){
            print(prev, s, prev[t]);
        }
        System.out.println(t+" ");
    }


    /**
     * 二叉树的广度优先遍历
     */
    private List<Integer> res = new ArrayList<>();

    /**
     * 非递归实现-借用队列
     * @param root
     */
    private void bfsTree(TreeNode root){
        if (root == null) return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.remove();
            res.add(current.val);
            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }
    }

    /**
     * 递归实现-二叉树的每一层用List记录
     * @param root
     */
    private void bfsTree_recursion(TreeNode root){
        List<List<Integer>> bfsRes = new ArrayList<>();
        find(bfsRes, 0, root);

        for (int i = 0; i < bfsRes.size(); i++) {
            res.addAll(bfsRes.get(i));
        }
    }

    private void find(List<List<Integer>> res, int level, TreeNode node){
        if (node == null) return;

        if (res.size() <= level){
            List<Integer> sub = new ArrayList<>();
            sub.add(node.val);
            res.add(sub);
        } else {
            res.get(level).add(node.val);
        }

        find(res, level+1, node.left);
        find(res, level+1, node.right);
    }
}
