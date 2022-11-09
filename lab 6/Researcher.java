class Researcher implements Comparable<Researcher>{
	public final int arrival;
	public final int leave;

	Researcher(int arrival, int stay) {
		this.arrival = arrival;
		this.leave = this.arrival + stay;
	}

	public int compareTo(Researcher b) {
        return this.arrival - b.arrival;
    }
}