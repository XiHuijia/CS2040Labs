//Xi Huijia, A0220056W
import java.util.*;


public class Conformity {
	public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int numOfStu = sc.nextInt();
    	Hashtable<HashSet<Integer>, Integer> combination = new Hashtable<HashSet<Integer>, Integer>();
    	
    	for (int i = 0; i < numOfStu; i++) {
    		sc.nextLine();
    		HashSet<Integer> modules = new HashSet<Integer>();
    		for (int j = 0; j < 5; j++) {
    			modules.add(sc.nextInt());
    		}

    		if (combination.containsKey(modules)) {
    			combination.put(modules, combination.get(modules) + 1);
    		} else {
    			combination.put(modules, 1);
    		}
    	}

    	int maxValue = Collections.max(combination.values());
    	int result =0;
    	for (int num: combination.values()) {
    		if (num == maxValue) {
    			result += num;
    		}
    	}
    	System.out.println(result);
    }
}