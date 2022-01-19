package Main.Huffman;

import Main.Node.Node;

public class Huffman {
	public static void print ( Node root , String s ) {
		if ( root.left == null && root.right == null && Character.isLetter ( root.c ) ) {
			System.out.println ( root.c + ":" + s );
			return;
		}
		assert root.left != null;
		assert root.right != null;
		print ( root.left , s + "0" );
		print ( root.right , s + "1" );
	}
}
