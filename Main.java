import java.util.*;
import java.io.*;

public class Main{
	
	private static Scanner sc = new Scanner(System.in);

    public static void main(String args[])throws FileNotFoundException{
		// The main class takes in two arguments, the dimension of the maze and the .txt file 
		// of the maze! We have provided 3 level mazes and one test maze. 
		// The level mazes are named: level0.txt, level1.txt, and level2.txt
		// These level mazes have a dimension of 12 so please input 12 as the first argument if
		// you choose to load the level maze. 
		// If you choose the tester.txt, please input 4 as the first argument.
		// One example of running this code would be: java Main 12 level0.txt
		Maze m = new Maze(Integer.parseInt(args[0]), args[1]);
        Player play = new HumanPlayer();
        int x = m.getX();
        int y = m.getY();
		Room r = m.mazeBoard[x][y];
		String playerName = "";
		char move = 'z';
		char playerType = 'Z';
       
        for(int i = 0; i < m.getDimension(); i++){
            System.out.println(m.getMaze()[i]);
		}
		Scanner s = new Scanner(new File("save.txt"));
		
		if(s.hasNext()){
			System.out.println("Welcome back, human. We will leave you to solve the maze from the last room you were in.");
			x = Integer.parseInt(s.next());
			y = Integer.parseInt(s.next());
			r = m.mazeBoard[x][y];
			s.close();
			playerType = 'H';
			playerName = "human";
			m.setX(x);
			m.setY(y);
			r.drawRoom();
		}
		
		else {
		   System.out.println("Before we begin, I must know, are you human or hardware?" +
		   "\n" + "Enter 'H' for 'Human' or 'M' for 'Machine.'");
		   playerType = sc.next().charAt(0);
		   
		   if(playerType == 'H'|| playerType == 'h'){
			   play = new HumanPlayer();
			   playerName = "human";
			   System.out.println("Welcome to my maze, human!" + 
						"\n" + "Enter 'N' to travel North, 'S' to travel South," +
						"\n" + "'E' to travel East, and 'W' to travel West." +
						"\n" + "Try not to lose your way!");
			}
			else if(playerType == 'M' || playerType == 'm'){
				play = new ComputerAI();
				playerName = "AI";
				System.out.println("Welcome to my maze, fellow machine!" + 
						"\n" + "Travel through the maze's rooms, and, most importantly," +
						"\n" + "find its end!");
			}
			else{
				play = new HumanPlayer();
				playerName = "human";
				System.out.println("You didn't answer my question correctly, human.");      
				for(int i = 0; i < 5; i++){
					if(playerType != 'H' || playerType != 'h' || playerType != 'M' || playerType != 'm'){
							playerType = sc.next().charAt(0); 
					} 
				}       		
			}
			r.drawRoom();
		}
		
		long startTime = System.nanoTime();
        while(!m.isGameOver()){
			if(r.exits == 0){
				System.out.print("Dead end! Go back!");
			}
			if(r.exits > 0){
				System.out.print("You have the option of going ");
				for(int n = 0; n < r.getDirections().length; n++){
					if(n != r.getDirections().length -1){
						System.out.print(r.getDirections()[n] + " or ");
					}
					else{
						System.out.print(r.getDirections()[n]);
					}
				}
				System.out.println();
			}
			if(playerName.equals("human")){
				move = sc.next().charAt(0);
			}
			if(playerName.equals("AI")){
				move = play.getMove(m);
			}
        	if((move == 'N'|| move == 'n')&&(r.containsDirection("North"))){
				System.out.println("You have chosen to go north!");
				play.movePosition(m, move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("N");
        	}
        	else if((move == 'S' || move == 's')&& (r.containsDirection("South"))){
				System.out.println("You have chosen to go south!");
				play.movePosition(m, move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("S");
        	}
        	else if((move == 'E' || move == 'e')&&(r.containsDirection("East"))){
				System.out.println("You have chosen to go east!");
				play.movePosition(m, move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("E");
        	}
        	else if((move == 'W' || move == 'w')&&(r.containsDirection("West"))){
				System.out.println("You have chosen to go west!");
				play.movePosition(m,move);
				r = m.mazeBoard[m.getX()][m.getY()];
				m.gameLog.add("W");
			}
			else if((move == 'Q' || move == 'q')){
				System.out.println("Quitting so soon?!");
				System.out.println("If you want to save your place in the maze, enter y twice. If not, press k twice.");
				if(sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y'){
					System.out.println(move);
					try{
						FileWriter fileWriter = new FileWriter("save.txt");
						fileWriter.write(new Integer(m.getX()).toString());
						fileWriter.write(System.lineSeparator());
						fileWriter.write(new Integer(m.getY()).toString());
						fileWriter.close();
						System.out.println("The game has been saved. Goodbye.");
					}
					catch(IOException e){
						e.printStackTrace();
						System.out.println("Error saving the location!");
					}
					System.exit(0);
				}
				else{
					System.out.println(move);
					System.exit(0);
				}
        	}
        	else{
        		System.out.println("I'm sorry, that's not a valid move. Please try again.");
        		continue;
        	}
		}
		long endTime = System.nanoTime();
		System.out.println("Congratulations, " + playerName +". You made it out of the maze and this journey took you "+ ((endTime - startTime)/1000000000) + " seconds!");
		System.out.println("During this game, you visited " + m.gameLog.size()+ " rooms to get to the destination.");
		try{
			FileWriter fileWriter = new FileWriter("save.txt");
			fileWriter.flush();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}