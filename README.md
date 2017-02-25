##二叉树求解
 * 整个求解的方法采用一个**递归**的思想，
 * 我们只需要在当前知晓的几种遍历结果中确定当前二叉树的根节点并且分离出根节点的左子树和右子树即可。
 * 
 * 譬如，一二叉树，前序遍历12743568，中序遍历47215386，后序遍历47258631，
 * ![二叉树图例](http://i.imgur.com/dH4syS9.png)
 * 假如知道**前序中序**了，根据前序我们知道**当前二叉树的根节点的值为1**，
 * 然后将1应用到中序里面，我们就知道根节点的**左子树的中序遍历结果为472，**根节点的**右子树的中序遍历结果为5386**，
 * 然后这里我们知道左子树上面有三个节点，所以应用到前序遍历中去，我们得知**左子树的前序遍历为274**，**右子树的前序遍历为3568**。

> 已知的条件，二叉树前序遍历为12743568，中序遍历为47215386


 整理一下，到这里我们就可以，得到三个结论：

	1.  当前二叉树的根节点的值为1

 ![得到根节点的值](http://i.imgur.com/xCWkRGS.png)

 	2.  当前二叉树的左子树的前序遍历为274，中序遍历为472（这里跟题目中已知的条件一样了，所以可以形成递归）
![得到左子树](http://i.imgur.com/GFv5Ug5.png)

 	3.  当前二叉树的右子树的前序遍历为3568，中序遍历为5386（这里跟题目中已知的条件一样了，所以可以形成递归）
  ![得到右子树](http://i.imgur.com/bvh4pXD.png)