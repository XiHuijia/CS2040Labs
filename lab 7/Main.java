//XI Huijia, A0220056W
import java.util.*;
class Main {
    public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		long numOfCommands = io.getLong();		

		QuestComparator comparator = new QuestComparator();
		TreeMap<Quest, Long> requestTree = new TreeMap<Quest, Long>(comparator);

		for (int i = 0; i < numOfCommands; i++) {
			String command = io.getWord();

			if (command.equals("add")) {
				long energy = io.getLong();
			    long gold = io.getLong();
			    Quest newQuest = new Quest(energy, gold);
			    if (requestTree.containsKey(newQuest)) {
			    	long frequency = requestTree.get(newQuest);
			    	requestTree.replace(newQuest, frequency + 1);
			    } else {
			    	requestTree.put(newQuest, 1l);
			    }
			    
			} else if (command.equals("query")) {
				long energy = io.getLong();
				long result = 0;
				while (energy > 0 && requestTree.floorKey(new Quest(energy, 100001)) != null) {
					Quest largest = requestTree.floorKey(new Quest(energy, 100001));
					result += largest.getGold();					
					energy -= largest.getEnergy();

					if (requestTree.get(largest) > 1) {
						long frequency = requestTree.get(largest);
			    	    requestTree.replace(largest, frequency - 1);
					} else {
						requestTree.remove(largest);
					}						
				}
				io.println(result);
			}			
		}
		io.close();
	}
}