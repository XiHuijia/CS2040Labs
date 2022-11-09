//Xi Huijia, A0220056W
import java.util.*;

public class T9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numOfLines = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[128];
        arr['a'] = "2";
        arr['b'] = "22";
        arr['c'] = "222";
        arr['d'] = "3";
        arr['e'] = "33";
        arr['f'] = "333";
        arr['g'] = "4";
        arr['h'] = "44";
        arr['i'] = "444";
        arr['j'] = "5";
        arr['k'] = "55";
        arr['l'] = "555";
        arr['m'] = "6";
        arr['n'] = "66";
        arr['o'] = "666";
        arr['p'] = "7";
        arr['q'] = "77";
        arr['r'] = "777";
        arr['s'] = "7777";
        arr['t'] = "8";
        arr['u'] = "88";
        arr['v'] = "888";
        arr['w'] = "9";
        arr['x'] = "99";
        arr['y'] = "999";
        arr['z'] = "9999";
        arr[' '] = "0";

        for (int i = 0; i < numOfLines; i++) {
            StringBuilder sb = new StringBuilder();
            String text = sc.nextLine();
            String lastPress = arr[text.charAt(0)];
            sb.append(lastPress);

            for (int j = 1; j < text.length(); j++) {
                String keyPressed = arr[text.charAt(j)];
                    if (keyPressed.charAt(0) == lastPress.charAt(0)){
                        sb.append(" ").append(keyPressed);
                    }
                    else {
                        sb.append(keyPressed);
                    }
                    lastPress = keyPressed;
            }
            System.out.println("Case #" + (i+1) + ": " + sb);
        }
    }
}
