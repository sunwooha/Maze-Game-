import java.util.*;

public class Main{
	
	private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
		// The main class takes in two arguments, the dimension of the maze and the .txt file 
		// of the maze! We have provided 3 level mazes and one test maze. 
		// The level mazes are named: level0.txt, level1.txt, and level2.txt
		// These level mazes have a dimension of 12 so please input 12 as the first argument if
		// you choose to load the level maze. 
		// If you choose the tester.txt, please input 4 as the first argument.
		// One example of running this code would be: java Main 12 level0.txt

        Maze m = new Maze(Integer.parseInt(args[0]), args[1]);
        Player play;
        int x = m.getX();
        int y = m.getY();
		Room r = m.mazeBoard[x][y];
       
        for(int i = 0; i < m.getDimension(); i++){
            System.out.println(m.getMaze()[i]);
        }  
        
        System.out.println("Before we begin, I must know, are you human or hardware?" +
        		"\n" + "Enter 'H' for 'Human' or 'M' for 'Machine.'");
        char playerType = sc.next().charAt(0);     
        
        if(playerType == 'H'|| playerType == 'h'){
        	play = new HumanPlayer();  
        	System.out.println("Welcome to my maze, human!" + 
        			"\n" + "Enter 'N' to travel North, 'S' to travel South," +
        			"\n" + "'E' to travel East, and 'W' to travel West." +
        			"\n" + "Try not to lose your way!");
        }
        else if(playerType == 'M' || playerType == 'm'){
        	play = new ComputerAI();
        	System.out.println("Welcome to my maze, fellow machine!" + 
        			"\n" + "Travel through the maze's rooms, and, most importantly," +
        			"\n" + "find its end!");
        }
        else{
        	play = new HumanPlayer();
        	System.out.println("You didn't answer my question correctly, human.");      
        	for(int i = 0; i < 5; i++){
        		if(playerType != 'H' || playerType != 'h' || playerType != 'M' || playerType != 'm'){
        			 playerType = sc.next().charAt(0); 
        		}        		
        	}
        }
        
		m.drawMazeRoom();
        long startTime = System.nanoTime();
        while(!m.isGameOver()){
        	char move = sc.next().charAt(0);
        	if((move == 'N'|| move == 'n')&&(r.containsDirection("North"))){
				play.movePosition(m, move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("N");
        	}
        	else if((move == 'S' || move == 's')&& (r.containsDirection("South"))){
				play.movePosition(m, move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("S");
        	}
        	else if((move == 'E' || move == 'e')&&(r.containsDirection("East"))){
				play.movePosition(m, move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("E");
        	}
        	else if((move == 'W' || move == 'w')&&(r.containsDirection("West"))){
				play.movePosition(m,move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("W");
        	}
        	else{
        		System.out.println("I'm sorry, that's not a valid move. Please try again.");
        		continue;
        	}
		}
		long endTime = System.nanoTime();
		System.out.println("Congratulations, you made it out of the maze and this journey took you "+ ((endTime - startTime)/1000000000) + " seconds!");
    }
}