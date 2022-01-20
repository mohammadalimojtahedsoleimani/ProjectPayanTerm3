package Main.Huffman;

import Main.Node.Node;

public class Huffman {
	public String str = "";
	
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
		if ( root == null ) {
			return;
		}
		char[] arr = s.toCharArray ( );
		int index = 0;
		StringBuilder rst = new StringBuilder ( );
		while ( index < arr.length ) {
			Node node = root;
			while ( node != null ) {
				if ( node.left == null && node.right == null ) {
					rst.append ( node.data );
					break;
				} else {
					char c = arr[ index ];
					if ( c == '0' ) {
						node = node.left;
					} else {
						node = node.right;
					}
					index++;
				}
			}
		}
		System.out.println ( rst );
	}
}
