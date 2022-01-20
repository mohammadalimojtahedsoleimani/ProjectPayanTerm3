package Main.App;

import Main.Huffman.Huffman;
import Main.Node.ComparatorOfNodes;
import Main.Node.Node;

import java.util.PriorityQueue;

public class Main {
	public static void main ( String[] args ) {
		Huffman hf = new Huffman ( );
		int n = 4;
		char[] charArray = { 'A' , 'B' , 'C' , 'D' };
		int[] frequencyOfChar = { 8 , 1 , 6 , 3 };
		
		PriorityQueue < Node > q = new PriorityQueue < Node > ( n , new ComparatorOfNodes ( ) );
		
		for ( int i = 0 ; i < n ; i++ ) {
			Node hn = new Node ( );
			
			hn.c = charArray[ i ];
			hn.data = frequencyOfChar[ i ];
			
			hn.left = null;
			hn.right = null;
			
			q.add ( hn );
		}
		
		Node root = null;
		
		while ( q.size ( ) > 1 ) {
			
			Node x = q.peek ( );
			q.poll ( );
			
			Node y = q.peek ( );
			q.poll ( );
			
			Node f = new Node ( );
			
			assert y != null;
			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;
			
			q.add ( f );
		}
		System.out.println ( " Char | Huffman code " );
		System.out.println ( "--------------------" );
		
		 hf.enCode ( root , "" );
		System.out.println ( hf.str );
		hf.decode ( hf.str , root );
	}
}
