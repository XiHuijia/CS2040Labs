/*
Name: Miao Tianjia
Student ID: A0222877W
*/

import java.util.*;
import java.io.*;


public class LostMap2 {
  public static ArrayList < ArrayList < IntegerPair > > AdjList;
  public static ArrayList < Boolean > taken;
  public static PriorityQueue < IntegerPair > pq;

  public static void process(int vtx) {
    taken.set(vtx, true);
    for (int j = 0; j < AdjList.get(vtx).size(); j++) {
      IntegerPair v = AdjList.get(vtx).get(j);
      if (!taken.get(v.first())) {
        pq.offer(new IntegerPair(v.second(), v.first(), v.third()));  // we sort by weight then by adjacent vertex
      }
  	}
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	String str = br.readLine();
	int n = Integer.parseInt(str);
	PriorityQueue<Pair> result = new PriorityQueue<Pair>();

    AdjList = new ArrayList < ArrayList < IntegerPair > >();

    for (int i = 0; i < n; i++) {
      ArrayList < IntegerPair > Neighbor = new ArrayList < IntegerPair >(); // create vector of Integer pair 
      AdjList.add(Neighbor); // store blank vector first
      str = br.readLine();
      String[] strarr = str.split(" ");
      for (int j = 0; j < n; j++) {
      	int value = Integer.parseInt(strarr[j]);
      	if (value != 0) {
      		Neighbor.add(new IntegerPair(j, value, i));
      	}
      }
    }
    pw.println(AdjList);

    taken = new ArrayList < Boolean >(); taken.addAll(Collections.nCopies(n, false));
    pq = new PriorityQueue < IntegerPair > ();
    // take any vertex of the graph, for simplicity, vertex 0, to be included in the MST
    process(0);
    
    while (!pq.isEmpty()) { // we will do this until all V vertices are taken (or E = V-1 edges are taken)
      IntegerPair front = pq.poll();

      if (!taken.get(front.second())) { // we have not connected this vertex yet
      	Integer min = Math.min(front.third() + 1, front.second() + 1);
      	Integer max = Math.max(front.third() + 1, front.second() + 1);
        result.add(new Pair(min, max));
        process(front.second());
      }
    }

    while (!result.isEmpty()) {
    	Pair cur = result.poll();
    	//pw.println(cur.first() + " " + cur.second());
    }

    br.close();
    pw.close();
  }
}

class IntegerPair implements Comparable<IntegerPair> {
  public Integer _first, _second, _third;

  public IntegerPair(Integer f, Integer s, Integer t) {
    _first = f;
    _second = s;
    _third = t;
  }

  public int compareTo(IntegerPair o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
  	else 
  	  return this.second() - o.second();
  }

  Integer first() { return _first; }

  Integer second() { return _second; }
  Integer third() { return _third;}

  public String toString() {
    return String.format("%d, %d, %d", _first, _second, _third);
  }
}


class Pair implements Comparable<Pair> {
  public Integer _first, _second;

  public Pair(Integer f, Integer s) {
    _first = f;
    _second = s;
  }

  public int compareTo(Pair o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
    else
      return this.second() - o.second();
  }

  Integer first() { return _first; }

  Integer second() { return _second; }
}
