//XI Huijia, A0220056W
import java.util.*;

class WeakVertice {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		while (true) {
			int numOfVertices = io.getInt();
			if (numOfVertices == -1) {
				break;
			}

			int[][] adjMatrix = new int[numOfVertices][numOfVertices];
			for (int i = 0; i < numOfVertices; i ++) {
				for (int j = 0; j < numOfVertices; j++) {
					adjMatrix[i][j] = io.getInt();
				}
			}

			for (int i = 0; i < numOfVertices; i++) {
				boolean isWeak = true;
				for (int j = 0; j < numOfVertices; j++) {
					for (int k = 0; k < numOfVertices; k++) {
						if (adjMatrix[i][j] == 1 && adjMatrix[i][k] == 1 && adjMatrix[j][k] == 1
							&& i != j && i!=k && j!=k) {
							isWeak = false;
						}
					}
				}
				if (isWeak == true) {
					io.print(i + " ");
			    }			
		    }
		    io.println();		
        }
        io.close();
    }
}