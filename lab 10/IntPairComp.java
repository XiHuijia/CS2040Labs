//Xi Huijia, A0220056W
import java.util.Comparator;
class IntPairComp implements Comparator<IntPair> {
	public int compare(IntPair x, IntPair y) {
		if (x.a != y.a) {
			return x.a-y.a;
		} else {
			return x.b-y.b;
		}
    }

	public boolean equals(Object obj) {
		return this == obj;
	}
}