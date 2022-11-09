//XI Huijia, A0220056W
import java.util.*;

class DoublePair {
	public final double a;
	public final double b;

	DoublePair(double a, double b) {
		this.a = a;
		this.b = b;
	}

	double distance(DoublePair another) {
		return Math.sqrt((this.a-another.a)*(this.a-another.a) + (this.b-another.b)*(this.b-another.b));
	}

	public String toString() {
		return String.format("(%s, %s)", a, b);
	}
}