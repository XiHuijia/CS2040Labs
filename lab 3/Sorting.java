//Xi Huijia, A0220056W
import java.util.*;

public class Sorting{
	public static void main(String args[]) {
		NameComparator nameComp = new NameComparator();
        Scanner sc = new Scanner(System.in);
        int numOfNames = sc.nextInt();
        while (numOfNames != 0) {       	
            sc.nextLine();
            List<String> nameList = new ArrayList<>();
            for (int i = 0; i < numOfNames; i++) {    
                nameList.add(sc.nextLine());  
            }
            Collections.sort(nameList, nameComp);
            for (int i = 0; i < numOfNames; i++) {    
                System.out.println(nameList.get(i));  
            }
            System.out.println();
            numOfNames = sc.nextInt();
        } 
    }

    
}