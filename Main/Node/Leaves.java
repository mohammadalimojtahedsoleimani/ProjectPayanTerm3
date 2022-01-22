package Main.Node;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode ( callSuper = true )
public class Leaves extends Node {
	
	public final char character;
	
	public Leaves ( char character , int freq ) {
		super ( freq );
		this.character = character;
	}
	
}
