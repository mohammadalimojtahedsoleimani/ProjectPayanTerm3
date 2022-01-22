package Main.App;

import Main.Huffman.Huffman;

import java.util.Scanner;

public class Main {
	public static void main ( String[] args ) {
		Scanner input = new Scanner ( System.in );
		String inp = input.next ( );
		
		Huffman hf = new Huffman ( inp );
		
		String text = hf.encode ( );
		System.out.println ( text );
		
		hf.print ( );
		
		String hfText = hf.decode ( text );
		System.out.println ( hfText );
		
	}
	
}
