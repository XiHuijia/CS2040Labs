//Xi Huijia, A0220056W
import java.util.*;

class Hand {
	private final int playerNo;
	private final String status;

	Hand(int playerNo, String status) {
		this.playerNo = playerNo;
		this.status = status;
	}

	int getPlayer() {
		return this.playerNo;
	}

	String getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "Player " + this.playerNo + "'s hand " + this.status;
	}
}