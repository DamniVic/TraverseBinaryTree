package com.damnivic;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
/**
 * 整个求解的方法采用一个递归的思想，
 * 我们只需要在当前知晓的几种遍历结果中确定当前二叉树的根节点并且分离出根节点的左子树和右子树即可。
 * 
 * 譬如，一二叉树，前序遍历12743568，中序遍历47215386，后序遍历47258631，
 * 
 * 假如知道前序中序了，根据前序我们知道当前二叉树的根节点的值为1，然后将1应用到中序里面，我们就知道根节点的左子树的中序遍历结果为472，
 * 根节点的右子树的中序遍历结果为5386，然后这里我们知道左子树上面有三个节点，所以应用到前序遍历中去，我们得知左子树的前序遍历为274，
 * 右子树的前序遍历为3568。
 * 
 * 已知的条件，二叉树前序遍历为12743568，中序遍历为47215386
 * 整理一下，到这里我们就可以，得到三个结论：
 * 1.当前二叉树的根节点的值为1
 * 2.当前二叉树的左子树的前序遍历为274，中序遍历为472（这里跟题目中已知的条件一样了，所以可以形成递归）
 * 3.当前二叉树的右子树的前序遍历为3568，中序遍历为5386（这里跟题目中已知的条件一样了，所以可以形成递归）
 */
	
	//知道前序中序求二叉树
	public static BinaryTreeNode constructCorePI(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("长度不一样，非法的输入");
        }
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.value = inorder[i];//确定当前二叉树的根节点的值并找到左子树和右子树的遍历
                System.out.print(root.value+",");
                root.leftNode = constructCorePI(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));//根据中序遍历可以确定左子树有多少个节点并从原遍历中分离出左子树的前序和中序遍历
                root.rightNode = constructCorePI(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));//根据中序遍历可以确定右子树有多少个节点并从原遍历分离出右子树的前序和中序遍历
                break;
            }
        }
        return root;
    }
	
//	private static ArrayList<BinaryTreeNode> list=new ArrayList<BinaryTreeNode>();
	//知道前序后序求二叉树
	public static BinaryTreeNode constructCorePL(int[] preorder,int[] lastorder) throws Exception{
		if(preorder==null||lastorder==null)
			return null;
		if(preorder.length!=lastorder.length)
			throw new Exception("长度不一样，非法的输入");
		BinaryTreeNode root=new BinaryTreeNode();
		root.value=lastorder[lastorder.length-1];
		if(lastorder.length>1)
		{
		int second=lastorder[lastorder.length-2];
		for(int i=1;i<preorder.length;i++)
		{
			if(second==preorder[i])
			{
				if(i!=1)
				{
					root.leftNode=constructCorePL(Arrays.copyOfRange(preorder, 1, i),Arrays.copyOfRange(lastorder, 0, i-1));
					root.rightNode=constructCorePL(Arrays.copyOfRange(preorder, i, preorder.length),Arrays.copyOfRange(lastorder, i-1, lastorder.length-1));
				}            
				else//当父节点只有一个子节点的时候，默认这个节点为左子节点
				{
//					BinaryTreeNode root2=root;
					root.leftNode=constructCorePL(Arrays.copyOfRange(preorder, 1, preorder.length),Arrays.copyOfRange(lastorder, 0, lastorder.length-1));
//					list.add(root);
//					root2.rightNode=constructCorePL(Arrays.copyOfRange(preorder, 1, preorder.length),Arrays.copyOfRange(lastorder, 0, lastorder.length-1));
//					list.add(root2);
				}
				break;
			}
		}
		}
		return root;
	}
	
	//知道中序后序求二叉树
	public static BinaryTreeNode constructCoreIL(int[] inorder,int[] lastorder) throws Exception{
		if(inorder==null||lastorder==null)
			return null;
		if(inorder.length!=lastorder.length)
			throw new Exception("长度不一样，非法的输入");
		BinaryTreeNode root=new BinaryTreeNode();
		for(int i=0;i<inorder.length;i++)
			if(inorder[i]==lastorder[lastorder.length-1])
			{
				root.value=inorder[i];
				root.leftNode=constructCoreIL(Arrays.copyOfRange(inorder, 0, i),Arrays.copyOfRange(lastorder, 0, i));
				root.rightNode=constructCoreIL(Arrays.copyOfRange(inorder, i+1, inorder.length),Arrays.copyOfRange(lastorder, i, inorder.length-1));
				break;
			}
		return root;
	}
}
