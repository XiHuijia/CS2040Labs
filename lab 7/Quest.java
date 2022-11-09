//XI Huijia, A0220056W
import java.util.*;
class Quest {
	private final long energy;
	private final long gold;

	Quest(long energy, long gold) {
        this.energy = energy;
        this.gold = gold;
	}

	long getEnergy() {
		return this.energy;
	}

	long getGold() {
		return this.gold;
	}

	public String toString() {
		return String.format("Energer %d with Gold %d", this.energy, this.gold);
	}
}