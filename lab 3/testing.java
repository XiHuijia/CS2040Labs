import java.util.*;
public class testing {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        	int numOfNames = sc.nextInt();
            System.out.println(numOfNames);
            sc.nextLine();
            List<String> nameList = new ArrayList<>();
            for (int i = 0; i < numOfNames; i++) {    
                nameList.add(sc.nextLine());  
            }
            Collections.sort(nameList);
            for (int i = 0; i < numOfNames; i++) {    
                System.out.println(nameList.get(i));  
            }
        } 
    }
