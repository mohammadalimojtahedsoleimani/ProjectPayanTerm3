package Main.Huffman;

import Main.Node.Node;

import java.lang.reflect.Type;

public class Huffman {
	public String str = "";
	public String decode_str = "";
	
	public void enCode ( Node root , String s ) {
		
		boolean isLetter = Character.isLetter ( root.c );
		if ( root.left == null && root.right == null && isLetter ) {
			System.out.println ( root.c + ":" + s );
			str += s;
			return;
		}
		assert root.left != null;
		assert root.right != null;
		enCode ( root.left , s + "0" );
		enCode ( root.right , s + "1" );
	}
	
	public void decode ( String s , Node root ) {
		StringBuffer sb = new StringBuffer ( );
		Node focus = root;
		for ( int i = 0 ; i < s.length ( ) ; i++ ) {
			assert focus != null;
			if ( s.charAt ( i ) == '1' ) {
				focus = focus.right;
			} else {
				focus = focus.left;
			}
			
			if ( focus != null && focus.left == null && focus.right == null ) {
				sb.append ( focus.data );
				focus = root;
			}
		}
		System.out.println (sb.toString () );
		
	}
}
