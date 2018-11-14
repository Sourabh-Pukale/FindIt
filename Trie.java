import java.io.*;
import java.util.*;

class TrieNode{
		
		boolean lastLetter;
		TrieNode[] charArray;

		TrieNode(){											/*Constructor*/

			charArray=new TrieNode[26];
			lastLetter=false;

			for(int i=0;i<26;i++){

				charArray[i]=null;
			}
		}
}



class Trie{
	
	TrieNode root;

	Trie(){													/*Constructor*/
		root=createTrieNode();
	}

	public TrieNode createTrieNode(){						/*Create Node of type TrieNode*/
		
		return (new TrieNode());
	}


	public void insert(TrieNode root,String word){				/*Insert a word in Trie*/

		word=word.toLowerCase();

		TrieNode traverse=root;

		for(int index=0;index<word.length();index++){

			int charValue=word.charAt(index) - 'a';

			if(traverse.charArray[charValue]==null){

				traverse.charArray[charValue]=createTrieNode();
			}
			traverse=traverse.charArray[charValue];
		}

		traverse.lastLetter=true;

	}

	public boolean search(TrieNode root,String word){			/*Search a word in Trie*/

		word=word.toLowerCase();

		TrieNode traverse=root;

		for(int index=0;index<word.length();index++){

			int charValue=word.charAt(index) - 'a';

			if(traverse.charArray[charValue]==null){

				return false;
			}
			traverse=traverse.charArray[charValue];
		}

		if(traverse.lastLetter==true){
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Trie tree=new Trie();
		tree.insert(tree.root,"Sourabh");
		tree.insert(tree.root,"Pukale");
		tree.insert(tree.root,"Money");
		System.out.println(tree.search(tree.root,"Sourabh"));
		System.out.println(tree.search(tree.root,"Pukale"));
		System.out.println(tree.search(tree.root,"Mone"));
	}

}