//XI Huijia, A0220056W
import java.util.*;
class WorkStation {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int count = 0;
		int numOfResearcher = io.getInt();
		int lockTime = io.getInt();

		PriorityQueue<Researcher> researchers = new PriorityQueue<>();
		for (int i = 0; i < numOfResearcher; i++) {
			int arrival = io.getInt();
			int leave = io.getInt();
			researchers.add(new Researcher(arrival, leave));
		}

		PriorityQueue<Integer> stations = new PriorityQueue<>();
		for (int i = 0; i < numOfResearcher; i++) {
			Researcher current = researchers.poll();
			while (!stations.isEmpty() && current.arrival > stations.peek() + lockTime) {
				stations.poll();
			}
			if (stations.isEmpty() || current.arrival < stations.peek()) {
				stations.add(current.leave);
			} else if (current.arrival >= stations.peek() && current.arrival <= stations.peek() + lockTime) {
				    stations.poll();
				    stations.add(current.leave);
				    count += 1;			    
			}			
		}
		io.println(count);
		io.close();
	}
}