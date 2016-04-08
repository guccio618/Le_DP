/*****************************************************************************
 * 以下几种方案适合用动态规划：
 * 		(1). 求最大／最小值
 * 		(2). 判断是否可行
 * 		(3). 统计方案个数 (非具体方案，否则通常用search)
 * 		(4). 当输入的数据是一个集合而不是序列时，不使用动规
 * 
 * 四大要素：
 * 		State, Function, Initialization, Answer
 * 
 * 记忆化搜索：适用于
 * 			(1). 状态转移方程特别麻烦，非顺序性
 * 			(2). 初始化状态不是很容易找到
 * 			(3). 记忆化搜索可以用 memo[i] != null 或者 memo[i] + visited[i]来判断
 * 				 是否已经计算过。
 * 
 * 区间DP: 此类题目共性就是区间最后求[0,n-1] 这样一个区间 逆向思维分析 从大到小就能迎刃而解
 * 		  类似分治法
 * 		  题目： 396， 476， 87， 312
 * 
 * 表达式匹配： 10, 44
 * 
 * 背包问题： 92, 125, 89
 * 
 * 重点题型： leetcode: 10, 87, 97, 139 + 140两种不同的解法， 300的 O(nlogn) 方法，
 * 					  312, 329简化方法 
 * 			lintcode: 89, 91, 125, 395, 396, 398, 476
 * 			单调栈：84, 85
 *   
 *****************************************************************************/

public class Datastructure_Definition {
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
  }
