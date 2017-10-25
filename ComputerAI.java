import java.util.*;

public class ComputerAI extends Player {

	public ComputerAI(){
	}

	// Since we cannot use the scanner to gather input for AI, we will randomly generate the chars.
	public char getMove(Maze m){
		Random rand = new Random();
		String[] dir = m.mazeBoard[m.getX()][m.getY()].getDirections();
		int max = dir.length - 1;
		int min = 0;
		char c = dir[(rand.nextInt(max - min + 1) + min)].charAt(0);
		return c;
	}
}
