package Main.App;

import Main.Huffman.Huffman;

import java.util.Scanner;

public class Main {
	public static void main ( String[] args ) {
		Scanner input = new Scanner ( System.in );
		String inp = input.next ( );
		
		Huffman huffman = new Huffman ( inp );
		
		String encodedText = huffman.encode ( );
		System.out.println ( encodedText );
		
		huffman.printCodes ( );
		
		String originalText = huffman.decode ( encodedText );
		System.out.println ( originalText );
		
	}
	
}
