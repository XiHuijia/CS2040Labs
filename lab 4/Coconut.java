//Xi Huijia, A0220056W
import java.util.*;

public class Coconut {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int syllables = sc.nextInt();
    	int players = sc.nextInt();

    	Deque<Hand> hands = new LinkedList<Hand>();
    	for (int i = 0; i < players; i++) {
    		hands.addLast(new Hand(i+1, "folded"));
    	}
        while (hands.size() > 1) {
        	for (int i = 0; i < syllables-1; i++) {
        		hands.addLast((hands.pop()));
        	}
            Hand currentHand = hands.peek();
            if (currentHand.getStatus().equals("folded")) {
            	int player = currentHand.getPlayer();
            	hands.pop();
            	hands.addFirst(new Hand(player, "fist"));
            	hands.addFirst(new Hand(player, "fist"));
            	            	            
        	} else if (currentHand.getStatus().equals("fist")) {
        		int player = currentHand.getPlayer();
        		hands.pop();
        		hands.addLast(new Hand(player, "palm"));
        		
        	} else if (currentHand.getStatus().equals("palm")) {
        		hands.pop();
        		
        	}
        }
        int winner = hands.peek().getPlayer();
        System.out.println(winner);
    }
}



//System.out.println(hands);