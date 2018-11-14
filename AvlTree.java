import java.io.*;
import java.util.*;

class AvlNode{
	
		String str;
		int height;
		AvlNode left,right,check,check2,check3;

		AvlNode(String temp){								/*Constructor*/

			str=temp;	
			height=1;
			left=right=null;
		}
}

public class AvlTree{
	
	AvlNode root;
	int getDiff;		

	AvlTree(){  											/*Constructor*/
		root=null;
	}

	public int max(int a,int b){							/*Find max between two integers*/

		if(a>b)return a;
		return b;
	}

	public int ht(AvlNode rt){									/*Get height of tree*/

		if(rt==null)return 0;
	   	else return rt.height;
	}

	public int getBalanceFactor(AvlNode rt){					/*Get Balance Factor of that AvlNode*/

		int leftHeight=ht(rt.left);
		int rightHeight=ht(rt.right);

		return (rightHeight-leftHeight);
	}

	public AvlNode leftRotate(AvlNode rt){						/*Left Rotate the AvlNode*/
		AvlNode son=rt.right;
		AvlNode temp=son.left;

		son.left=rt;
		rt.right=temp;

		rt.height=1+ max(ht(rt.left),ht(rt.right));
		son.height=1+ max(ht(son.left),ht(son.right));
		
		return son;
	}

	public AvlNode rightRotate(AvlNode rt){						/*Right Rotate the AvlNode*/

		AvlNode son=rt.left;
		AvlNode temp=son.right;
		
		son.right=rt;
		rt.left=temp;
		
		rt.height=1+ max(ht(rt.left),ht(rt.right));
		son.height=1+ max(ht(son.left),ht(son.right));
		
		return son;
	}

	public AvlNode insert(AvlNode rt,String s){					/*Insert String in the tree*/

		if(rt==null){
			return (new AvlNode(s)); 
		}
		getDiff=(rt.str).compareToIgnoreCase(s);
	 	
	 	
	 	
	 	if(getDiff<0){
	 		rt.left=insert(rt.left,s);
		}
		
		else if(getDiff>0){
			rt.right=insert(rt.right,s);
		}
		
		else
			return rt;

		


		int balance=getBalanceFactor(rt);
		getDiff=0;
		
		if(rt.right!=null)
			getDiff=((rt.right).str).compareToIgnoreCase(s);
		
		
		if(balance>1 && getDiff>0)	
			return leftRotate(rt);
		
		else if(balance>1 && getDiff<0){

			rt.right=rightRotate(rt.right);
			return leftRotate(rt);
		}
		
		getDiff=0;
		
		if(rt.left!=null)
			getDiff=((rt.left).str).compareToIgnoreCase(s);
		
		if(balance<-1 && getDiff>0){

			rt.left=leftRotate(rt.left);
			return rightRotate(rt);
		} 
		
		else if(balance<-1 && getDiff<0){

			return rightRotate(rt);
		}

		rt.height=1 + max(ht(rt.right),ht(rt.left));
		return rt;
	}

	void display(AvlNode rt){										/*Display the tree*/

		if(rt==null)return ;
		display(rt.left);
		display(rt.right);
		System.out.println(rt.str);
	}

	public int search(AvlNode rt,String s){						/*Search given word in the tree*/
		
		if(rt==null)
			return 0;
		getDiff=(rt.str).compareToIgnoreCase(s);
		
		if(getDiff>0){
		
			return search(rt.right,s);
		}
		else if(getDiff<0){
		
			return search(rt.left,s);	
		}
		else{
			
			return 1;
		}
		
	}

	public static void main(String[] args) {
		
		AvlTree tree=new AvlTree();
		tree.root=tree.insert(tree.root,"SOURABH");
		tree.root=tree.insert(tree.root,"SOUR");
		tree.root=tree.insert(tree.root,"SABH");
		System.out.println(tree.search(tree.root,"SABH"));
		System.out.println(tree.search(tree.root,"King"));
	}
}