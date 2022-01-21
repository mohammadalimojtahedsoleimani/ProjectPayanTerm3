package Main.Node;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node> {
	
	public final int frequency;
	public Node leftNode;
	public Node rightNode;
	
	public Node(Node leftNode, Node rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
	}
	
	@Override
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
	
}
