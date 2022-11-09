//Xi Huijia, A0220056W

import java.util.*;

public class PeaSoup {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
	    int numOfRes = sc.nextInt();

	for(int i = 0; i < numOfRes; i++){
		boolean peasoup = false;
		boolean pancake = false;
		int numOfItems = sc.nextInt();
		sc.nextLine();
		String resName = sc.nextLine();

		for(int j = 0; j < numOfItems; j++){
			String item = sc.nextLine();
			if(item.equals("pea soup")){
				peasoup = true;	
			}else if(item.equals("pancakes")){
			        pancake = true;
			}
		}
		if(peasoup == true && pancake == true){
			System.out.println(resName);
			return;	
		}	        
	}
    System.out.println("Anywhere is fine I guess");    
    }
} 
