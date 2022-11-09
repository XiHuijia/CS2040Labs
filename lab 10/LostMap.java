//XI Huijia, A0220056W
import java.util.*;

class LostMap {
	public static ArrayList<ArrayList<Edge>> adjList;
	public static ArrayList<Boolean> taken;
    public static PriorityQueue<Edge> pq;
    public static PriorityQueue<IntPair> result;

	public static void process(int vtx) {
		taken.set(vtx, true);
		for (int k = 0; k < adjList.get(vtx).size(); k++) {
			Edge edge = adjList.get(vtx).get(k);
			if(!taken.get(edge.first)) {
				pq.offer(new Edge(edge.second, edge.first, edge.third));
			}
		}
	}
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();

		adjList = new ArrayList<ArrayList<Edge>>();
		
		taken = new ArrayList<Boolean>();
		taken.addAll(Collections.nCopies(n, false));
		
		pq = new PriorityQueue<Edge>(new EdgeComp());
		result = new PriorityQueue<IntPair>(new IntPairComp());

		for (int i = 0; i < n; i++) {
			ArrayList<Edge> neighbors = new ArrayList<Edge>();			
			for (int j = 0; j < n; j++) {
				int distance = io.getInt();
				if (distance != 0) {
					neighbors.add(new Edge(j, distance, i));
				}				
			}
			adjList.add(neighbors);			
		}
		//io.println(adjList);

		process(0);
		while(!pq.isEmpty()) {
			Edge current = pq.poll();

			if(!taken.get(current.second)) {
				int x = current.second + 1;
				int y = current.third + 1;
				result.offer(new IntPair(Math.min(x, y), Math.max(x, y)));
				process(current.second);
			}
		}

		while (!result.isEmpty()) {
			IntPair pair = result.poll();
			io.println(String.format("%d %d", pair.a, pair.b));
		}

        io.close();
	}
}