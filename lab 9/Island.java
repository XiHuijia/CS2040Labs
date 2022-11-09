//XI Huijia, A0220056W
import java.util.*;

class Island {
	static void BFS(Queue queue, String[][] adjMatrix1, int[][] adjMatrix2) {
		int[] direction1 = {0, 0, 1, -1};
		int[] direction2 = {1, -1, 0, 0};
		while (!queue.isEmpty()) {
			Pair temp = (Pair)queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = temp.x + direction1[i];
				int newY = temp.y + direction2[i];
				if (newX < 0 || newX >= adjMatrix1.length || newY < 0 || newY >= adjMatrix1[0].length) {
					continue;					
				}

				if ((adjMatrix1[newX][newY].equals("C") || adjMatrix1[newX][newY].equals("L")) && adjMatrix2[newX][newY] == 0) {
					queue.add(new Pair(newX, newY));
					adjMatrix2[newX][newY] = 1;
				}
			}	
		}
	}
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int row = io.getInt();
		int col = io.getInt();
		int answer = 0;

		String[][] adjMatrix1 = new String[row][col];  //read input data
		int[][] adjMatrix2 = new int[row][col];  //boolean array matrix to record visited cells
		
		for (int i = 0; i < row; i++) {
			String line = io.getWord();
			for (int j = 0; j < col; j++) {				
				adjMatrix1[i][j] = String.valueOf(line.charAt(j));
				adjMatrix2[i][j] = 0;
			}
		}
		//System.out.println(adjMatrix1[0][0]);

		Queue<Pair> queue = new LinkedList<Pair>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (adjMatrix1[i][j].equals("L") && adjMatrix2[i][j] == 0) {
					answer ++;
					queue.add(new Pair(i, j));
					adjMatrix2[i][j] = 1;
					BFS(queue, adjMatrix1, adjMatrix2);					
				}
			}		
		}
		io.println(answer);		
		io.close();
	}
}