//XI Huijia, A0220056W
import java.util.*;

class Edge {
	public final int first;
	public final int second;
	public final int third;

	Edge(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public String toString() {
		return String.format("(%s, %s, %s)", first, second, third);
	}
}