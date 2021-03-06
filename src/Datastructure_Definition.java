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
 * 重点题型： leetcode: **10, **32, **44, 53, *72, *85, **87, **91, **95, **96, *97, **115(初始化), 120, **123, **132, 
 * 			**139 + 140两种不同的解法, 152, **188, 213, 263, **264, 276, **279, *300的 O(nlogn) 方法，*304, 309, **312, 
 * 			329简化方法, **343, **351, 354, *357
 * 			
 * 			lintcode: *77, *79, **89, **91, **92, **125, **395, 396, 398, **476
 * 
 * 			字符串对比类: **10, **44, *72, *97, **115(初始化)
 * 			字符串查找类：**131, **132, **139, **140, *li_77, *li_79,  
 * 			查找最大正方形，矩形，对角正方形: *221, *85, 
 * 			博弈类: 293, *294, li_394, **li_395, **li_396
 * 			区间类：**87, **312, li_396, li_476
 * 			背包问题: li_92, li_125, li_440
 * 			单调栈：84, 85	
 * 			连续增加子串类: **300, *315(Count of Smaller Numbers After Self), *329, *li_77, *li_79, *li_397, 
 * 			连续子串最大和／乘积: 53, 152
 * 
 * 			
 * 			
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
