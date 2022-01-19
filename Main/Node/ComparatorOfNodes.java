package Main.Node;

import Main.Node.Node;

import java.util.*;

public class ComparatorOfNodes implements Comparator < Node > {
	public int compare ( Node a , Node b ) {
		return a.data - b.data;
	}
}
