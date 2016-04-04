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
 * 重点题型： 139 + 140两种不同的解法， 300的nlogn方法， 97， 329简化方法
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
