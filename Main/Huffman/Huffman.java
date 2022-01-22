package Main.Huffman;


import Main.Node.Leaves;
import Main.Node.Node;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class Huffman {
	
	public Node root;
	public final String text;
	public Map < Character, Integer > charFreq;
	public final Map < Character, String > huffman;
	
	
	public Huffman ( String text ) {
		this.text = text;
		fillCharFrequenciesMap ( );
		huffman = new HashMap <> ( );
	}
	
	public void fillCharFrequenciesMap ( ) {
		charFreq = new HashMap <> ( );
		char[] charArray;
		charArray = text.toCharArray ( );
		for ( char character : charArray ) {
			Integer integer = charFreq.get ( character );
			charFreq.put ( character , integer != null ? integer + 1 : 1 );
		}
	}
	
	
	public String encode ( ) {
		PriorityQueue < Node > qu = new PriorityQueue <> ( );
		for ( Map.Entry < Character, Integer > entry : charFreq.entrySet ( ) ) {
			Character character = entry.getKey ( );
			Integer frequency = entry.getValue ( );
			qu.add ( new Leaves ( character , frequency ) );
		}
		while ( qu.size ( ) > 1 ) qu.add ( new Node ( qu.poll ( ) , requireNonNull ( qu.poll ( ) ) ) );
		huffmanCodeGenerator ( root = qu.poll ( ) , "" );
		return getTextOfEncoded ( );
	}
	
	public void huffmanCodeGenerator ( Node node , String code ) {
		if ( node instanceof Leaves ) {
			huffman.put ( ( ( Leaves ) node ).getCharacter ( ) , code );
			return;
		}
		huffmanCodeGenerator ( node.getLeft ( ) , code.concat ( "0" ) );
		huffmanCodeGenerator ( node.getRight ( )
				, code.concat ( "1" ) );
	}
	
	public String getTextOfEncoded ( ) {
		var sb = new StringBuilder ( );
		for ( char character : text.toCharArray ( ) ) sb.append ( huffman.get ( character ) );
		return sb.toString ( );
	}
	
	
	public String decode ( String encodedText ) {
		StringBuilder sb = new StringBuilder ( );
		Node current = root;
		char[] charArray = encodedText.toCharArray ( );
		for ( int i = 0, arrayLength = charArray.length ; i < arrayLength ; i++ ) {
			char character = charArray[ i ];
			current = character == '0' ? current.getLeft ( ) : current.getRight ( );
			if ( current instanceof Leaves ) {
				sb.append ( ( ( Leaves ) current ).getCharacter ( ) );
				current = root;
			}
		}
		return sb.toString ( );
	}
	
	
	public void print ( ) {
		huffman.forEach ( ( character , code ) ->
				System.out.println ( character + ": " + code )
		);
	}
	
}