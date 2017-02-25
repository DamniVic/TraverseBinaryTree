package com.damnivic;
import javax.swing.JFrame;

import com.damnivic.Solution;

public class TestDemo {
	public static void main(String args[])
	{
		int[] preorder={1,2,7,4,3,5,6,8};//二叉树的前序遍历
		int[] inorder={4,7,2,1,5,3,8,6};//二叉树的中序遍历
		int[] lastorder={4,7,2,5,8,6,3,1};//二叉树的后序遍历
		BinaryTreeNode root = null;
		
		//知道前序中序后求二叉树并用三种遍历打印出来
		try {
			root=Solution.constructCorePI(preorder,inorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("知道前序中序求二叉树");
		printBTPre(root);
		System.out.println();
		printBTIn(root);
		System.out.println();
		printBTLast(root);
		System.out.println();
		
		//知道中序后序后求二叉树并用三种遍历打印出来
		try {
			root=Solution.constructCoreIL(inorder,lastorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("知道中序后序求二叉树");
		printBTPre(root);
		System.out.println();
		printBTIn(root);
		System.out.println();
		printBTLast(root);
		System.out.println();
		
		//知道前序后序求二叉树并用三种遍历打印出来
		try {
			root=Solution.constructCorePL(preorder,lastorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("知道前序后序求二叉树");
		printBTPre(root);
		System.out.println();
		printBTIn(root);
		System.out.println();
		printBTLast(root);
		System.out.println();
//		JFrame jf=new JFrame();
//		jf.setSize(500, 500);
//		jf.setLocation(500, 500);
//		jf.show();
	}
	
	//前序遍历打印二叉树
	private static void printBTPre(BinaryTreeNode root)
	{
		if(root.value!=0)
			System.out.print(root.value);
		if(root.leftNode!=null)
			printBTPre(root.leftNode);
		if(root.rightNode!=null)
			printBTPre(root.rightNode);
	}
	
	//中序遍历打印二叉树
	private static void printBTIn(BinaryTreeNode root)
	{
		if(root.leftNode!=null)
			printBTIn(root.leftNode);
		if(root.value!=0)
			System.out.print(root.value);
		if(root.rightNode!=null)
			printBTIn(root.rightNode);
	}
	
	//后序遍历打印二叉树
	private static void printBTLast(BinaryTreeNode root)
	{
		if(root.leftNode!=null)
			printBTLast(root.leftNode);
		if(root.rightNode!=null)
			printBTLast(root.rightNode);
		if(root.value!=0)
			System.out.print(root.value);
	}
}
