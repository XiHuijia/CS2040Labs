//Xi Huijia, A0220056W
import java.util.Comparator;
class EdgeComp implements Comparator<Edge> {
	public int compare(Edge a, Edge b) {
		if (a.first != b.first) {
			return a.first - b.first;
		} else {
			return a.second - b.second;
		}
    }

	public boolean equals(Object obj) {
		return this == obj;
	}
}