package Main.Node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import Main.Node.Node;

@Getter
@EqualsAndHashCode ( callSuper = true )
public class Leaf extends Node {
	
	public final char character;
	
	public Leaf ( char character , int frequency ) {
		super ( frequency );
		this.character = character;
	}
	
}
