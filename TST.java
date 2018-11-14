import java.io.*;
import java.util.*;

class Node{
	
	char character;
	Node left,right,equal;
	boolean end;

	
	Node(char character){								/*Constructor*/
		this.character=character;
		this.left=null;
		this.right=null;
		this.equal=null;
		end=false;
	}

}

class TST{

	Node head;
	
	
	public Node createNode(char character){    			/*Initialize new Node*/
		return (new Node(character));
	}


	
	public boolean search(Node root,String word){		/*Insert the given word*/
		return searchTST(root,word,0);
	}

	
	public Node insert(Node root,String word){			/*Search the given word*/
		return insertTST(root,word,0);
	}


	
	public Node insertTST(Node root,String word,int index){			/*Insert into Ternary Search Tree*/
		
		char character=word.charAt(index);

		if(root==null){
			root=createNode(character);
		}
		if(character<root.character){
			root.left=insertTST(root.left,word,index);
		}

		else if(character>root.character){
			root.right=insertTST(root.right,word,index);	
		}

		else{
			if((index+1)<=(word.length()-1))
				root.equal=insertTST(root.equal,word,index+1);
			else
				root.end=true;
		}
		return root;
	}

	
	public boolean searchTST(Node root,String word,int index){			/*Search in Ternary Search Tree*/
		
		char character=word.charAt(index);		
		
		if(root==null){
			return false;
		}

		if(character<root.character){
			return searchTST(root.left,word,index);
		}

		else if(character>root.character){
			return searchTST(root.right,word,index);	
		}

		else{
			
			if((index+1)<=(word.length()-1))
				return searchTST(root.equal,word,index+1);
			
			else{
			
				if(root.end==true){
					return true;
				}
			}
			
		}
		return false;
	}

	

	public static void main(String[] args){
		TST root=new TST();
		root.head=null;
		root.head=root.insert(root.head,"Sourabh");
		root.head=root.insert(root.head,"Pukale");
		root.head=root.insert(root.head,"Competitive");
		root.head=root.insert(root.head,"Love");
		System.out.println(root.search(root.head,"Sourabh"));
		System.out.println(root.search(root.head,"Competitive"));
		System.out.println(root.search(root.head,"hate"));
	}
}


