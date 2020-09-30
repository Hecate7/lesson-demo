package perday.perday_0926_113.prepare;

import java.util.LinkedList;

/**
 * 图：与树相比，是一种更复杂的非线性表结构
 * 顶点(vertex)：图中的元素
 * 边(edge)：顶点和其他任意顶点建立的连接关系
 * 度(degree)：与顶点相连接的边的条数。入度-出度
 *
 * 有向图-无向图-带权图
 *
 * 如何存储微博中的好友关系-采用邻接表维护
 * 1.获取用户的粉丝列表：维护逆邻接表
 * 2.支持快速查找：选用跳表改进邻接表中链表（跳表的插入、删除、查找的时间复杂度为O(n)，空间复杂度为O(n)，跳表中存储的数据是有序的，分页获取十分高效）
 * 3.数据规模大：1.通过哈希算法等数据分片算法，将邻接表存储在不同的机器上。查询时，采用同样的哈希算法，定位到所在的机器
 *               2.采用外部存储
 */
public class Graph {

    /**
     * 邻接矩阵
     * 邻接矩阵底层依赖一个二维数组A
     * 无向图：顶点i与顶点j之间有边，标记A[i][j]和A[j][i]为1
     * 有向图：顶点i指向顶点j的边，标记A[i][j]为1
     * 带权图：数组中存储对应的权值
     *
     * 邻接矩阵存储耗费空间，使用节省时间
     *
     * 优点：1.基于数据，获取两个顶点间的关系时十分高效
     *       2.方便计算，可以将图的运算转换为矩阵之间的计算【弗洛伊德算法-解决两点间的最短路径】
     * 缺点：浪费存储空间
     *      1.无向图的二维数组中，只需要里用对角线上面或下面的一半空间
     *      2.稀疏图浪费了绝大部分空间
     */
    class adjacencyMatrix{
        private int v;
        private int[][] adj;

        public adjacencyMatrix(int v) {
            this.v = v;
            adj = new int[v][v];
        }

        public void addEdge(int s, int t){
            adj[s][t] = 1;
            adj[t][s] = 1;
        }
    }

    /**
     * 邻接表
     * 每个顶点对应一条链表，链表中存储的是与这个顶点相连的其他顶点
     * 有向图：存储的是指向的顶点
     * 无向图：存储的相连的顶点
     *
     * 邻接表存储比较节省空间，但是使用起来比较耗时间
     *
     * 缺点：1.获取两个结点之间的关系需要遍历顶点对应的链表,链表的存储方式对缓存不友好，不高效
     *
     * 可以将邻接表的链表改成平衡二叉查找树、跳表、散列表等动态数据结构
     * 还可以将链表改成有序动态数组，通过二分查找的方法快速定位两个顶点之间是否有边
     *
      */
    class adjacencyList{
        //顶点的个数
        public int v;
        //邻接表
        public LinkedList<Integer>[] adj;

        public adjacencyList(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t){
            adj[s].add(t);
            adj[t].add(s);
        }
    }
}
