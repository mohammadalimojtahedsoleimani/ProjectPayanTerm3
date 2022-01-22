package Main.Node;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node> {
	
	public final int frequency;
	public Node left;
	public Node right;
	
	public Node( Node left , Node right) {
		this.left = left;
		this.right = right;
		this.frequency = left.getFrequency() + right.getFrequency();
	}
	
	@Override
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
	
}
