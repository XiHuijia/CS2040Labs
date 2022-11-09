//XI Huijia, A0220056W
import java.util.*;

class Main {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		DoublePair start = new DoublePair(io.getDouble(),io.getDouble());
		DoublePair end = new DoublePair(io.getDouble(),io.getDouble()); 
		
		int numOfCannons = io.getInt();

		DoublePair[] cannons = new DoublePair[numOfCannons + 2];
		cannons[0] = start;
		cannons[numOfCannons+1] = end;

		for (int i = 1; i <= numOfCannons; i++) {
			cannons[i] = new DoublePair(io.getDouble(),io.getDouble());
		}

		double infinity = start.distance(end)/5 + 1;

		double[][] adjMatrix = new double[numOfCannons + 2][numOfCannons + 2];
		for(int i = 0; i < numOfCannons + 2; i++) {
			for (int j = 0; j < numOfCannons + 2; j++) {
				adjMatrix[i][j] = infinity;
			}			
			adjMatrix[i][i] = 0;
		}


		for(int i = 1; i < numOfCannons+2; i++) {
			adjMatrix[0][i] = start.distance(cannons[i])/5;
		}


		for(int i = 1; i < numOfCannons+1; i++) {
			for (int j = 1; j < numOfCannons + 2; j++) {
				adjMatrix[i][j] = Math.min((Math.abs(cannons[i].distance(cannons[j])-50)/5 + 2), cannons[i].distance(cannons[j])/5);
			}
		}

		// io.println(Arrays.toString(adjMatrix[0]));
		// io.println(Arrays.toString(adjMatrix[1]));
		// io.println(Arrays.toString(adjMatrix[2]));
		// io.println(Arrays.toString(adjMatrix[3]));
		// io.println(Arrays.toString(adjMatrix[4]));
		// io.println(Arrays.toString(adjMatrix[5]));


		for (int k = 0; k < numOfCannons + 2; k++) {
			for(int i = 0; i < numOfCannons + 2; i++) {
				for (int j = 0; j < numOfCannons + 2; j++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
				}
			}
		}
		

		io.println(adjMatrix[0][numOfCannons + 1]);
		io.close();
	}
}