//XI Huijia, A0220056W
import java.util.*;
class QuestComparator implements Comparator<Quest> {
	public int compare(Quest a, Quest b) {
		if (a.getEnergy() == b.getEnergy()) {
			return (int)(a.getGold() - b.getGold());
		} else {
			return (int)(a.getEnergy() - b.getEnergy());
		}
	}
}