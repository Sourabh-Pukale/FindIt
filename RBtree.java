import java.io.*;
import java.util.*;

class RBNode{

	char color;
	String s;
	RBNode left,right,parent;
	RBNode(String ip){								/*Constructor*/

		s=ip;
		color='R';
		left=null;
		right=null;
		parent=null;
	}
}



public class RBtree{

	RBNode root;
	int getDiff=0;
	RBNode nillT;
		
	RBtree(){										/*Constructor*/
		nillT=new RBNode("");
		nillT.color='B';
		root=null;
	}

	public RBNode getParent(RBNode rt){				/*Get Parent of RBNode*/

		return rt.parent;
	}

	public void leftRotate(RBNode son){				/*Left Rotate the given Red Black Tree*/

		RBNode dad=getParent(son);
		RBNode temp=son.left;
		RBNode grandpa=getParent(dad);

		son.left=dad;
		dad.right=temp;
		
		if(grandpa!=null){
		
			if(grandpa.left==dad)
				grandpa.left=son;
			else
				grandpa.right=son;
		}
		
		temp=dad.parent;
		dad.parent=son;
		son.parent=temp;
	}

	public void rightRotate(RBNode son){			/*Right Rotate the given Red Black Tree*/
		
		RBNode dad=getParent(son);
		RBNode temp=son.right;
		RBNode grandpa=getParent(dad);
		
		son.right=dad;
		dad.left=temp;
		
		if(grandpa!=null){
		
			if(grandpa.left==dad)
				grandpa.left=son;
			else
				grandpa.right=son;
		}
		
		temp=dad.parent;
		dad.parent=son;
		son.parent=temp;

	}

	public RBNode getRoot(RBNode son){					/*Get Root of the given Red Black Tree*/

		while(getParent(son)!=null){
			son=getParent(son);
		}
		return son;
	}

	public RBNode insert(RBNode rt,String s){			/*Insert in the given Red Black Tree*/

		RBNode dad=null,son=null;
		if(rt==null){
			
			RBNode tmp=new RBNode(s);
			tmp.color='B';
			return (tmp);
		}
		
		while(rt!=null){
			
			dad=rt;
			getDiff=(rt.s).compareToIgnoreCase(s);
			
			if(getDiff<=0){
			
				rt=rt.right;
			}
			else{
			
				rt=rt.left;
			}
		}
		
		
		son=new RBNode(s);
		son.parent=dad;
		if(getDiff<=0)dad.right=son;
		else dad.left=son;
		
		

		while(dad.color=='R'){
			
		
			dad=getParent(son);
			RBNode grandpa=getParent(dad);
			RBNode uncle;
		
			if(grandpa.left==dad){
		
					uncle=grandpa.right;
				
					if(uncle==null){
						uncle=new RBNode("");
						uncle.color='B';
					}

					if(uncle.color=='R'){
						dad.color='B';
						uncle.color='B';
						grandpa.color='R';
						son=grandpa;
						dad=getParent(son);
						if(dad==null){
		
							dad=new RBNode("");
							dad.color='B';
							son.color='B';
						}
						continue;
					}
					
					else if(uncle.color=='B' && son==dad.right){
					
						RBNode temp=dad;
						leftRotate(son);
						son=temp;
						dad=getParent(son);
					}
					dad.color='B';
					grandpa.color='R';
					rightRotate(dad);
				
			}
			else{
				
				uncle=grandpa.left;
		
				if(uncle==null){
					
					uncle=new RBNode("");
					uncle.color='B';
					
				}	
					if(uncle.color=='R'){
						
						dad.color=uncle.color='B';
						grandpa.color='R';
						son=grandpa;
						dad=getParent(son);
		
						if(dad==null){
							dad=new RBNode("");
							dad.color='B';
							son.color='B';
						}

						continue;
					}
					
					
					else if(uncle.color=='B' && son==dad.left){
						

						RBNode temp=dad;
						rightRotate(son);
						son=dad;
						dad=getParent(son);
					}
					
					dad.color='B';
					grandpa.color='R';
					leftRotate(dad);
				
				
			}
			rt=getRoot(son);
			rt.color='B';
		}
		
		

		return getRoot(son);
	}

	void display(RBNode rt){							/*Display the given Red Black Tree*/
		
		if(rt==null){
			System.out.println("null");
			return ;
		}
		System.out.println(rt.s+" "+rt.color);
		display(rt.left);
		display(rt.right);
		
	}


	public static void main(String[] args) {
		RBtree tree=new RBtree();

		tree.root=tree.insert(tree.root,"a.");
		

		tree.root=tree.insert(tree.root,"b.");
		

		tree.root=tree.insert(tree.root,"c.");
		

		tree.root=tree.insert(tree.root,"ce.");

		
		tree.root=tree.insert(tree.root,"f.");
		

		tree.root=tree.insert(tree.root,"l.");
		

		tree.root=tree.insert(tree.root,"sd.");


		tree.root=tree.insert(tree.root,"fg.");
		

		tree.root=tree.insert(tree.root,"df.");


		tree.root=tree.insert(tree.root,"dfg");


		tree.root=tree.insert(tree.root,"dkl");

			
		tree.display(tree.root);
	}

}