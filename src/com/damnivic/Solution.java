package com.damnivic;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	//֪��ǰ�������������
	public static BinaryTreeNode constructCorePI(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("���Ȳ�һ�����Ƿ�������");
        }
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.value = inorder[i];
                System.out.print(root.value+",");
                root.leftNode = constructCorePI(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                root.rightNode = constructCorePI(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }
	
	private static ArrayList<BinaryTreeNode> list=new ArrayList<BinaryTreeNode>();
	//֪��ǰ������������
	public static BinaryTreeNode constructCorePL(int[] preorder,int[] lastorder) throws Exception{
		if(preorder==null||lastorder==null)
			return null;
		if(preorder.length!=lastorder.length)
			throw new Exception("���Ȳ�һ�����Ƿ�������");
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
				else//�����ڵ�ֻ��һ���ӽڵ��ʱ��Ĭ������ڵ�Ϊ���ӽڵ�
				{
//					BinaryTreeNode root2=root;
					root.leftNode=constructCorePL(Arrays.copyOfRange(preorder, 1, preorder.length),Arrays.copyOfRange(lastorder, 0, lastorder.length-1));
//					list.add(root);
//					root2.rightNode=constructCorePL(Arrays.copyOfRange(preorder, 1, preorder.length),Arrays.copyOfRange(lastorder, 0, lastorder.length-1));
//					list.add(root2);
				}
			}
		}
		}
		return root;
	}
	
	//֪����������������
	public static BinaryTreeNode constructCoreIL(int[] inorder,int[] lastorder) throws Exception{
		if(inorder==null||lastorder==null)
			return null;
		if(inorder.length!=lastorder.length)
			throw new Exception("���Ȳ�һ�����Ƿ�������");
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