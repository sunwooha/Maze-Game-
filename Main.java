import java.util.*;

public class Main{
	
	private static Scanner sc = new Scanner(System.in);

    public static void main(String argv[]){
        String level0 = "level0.txt";
        String level1 = "level1.txt";
        String level2 = "level2.txt";
        Maze m = new Maze(12, level0);
        Player play;
        int x = m.getX();
        int y = m.getY();
        Room r = m.mazeBoard[x][y];
       
        for(int i = 0; i < m.getDimension(); i++){
            System.out.println(m.getMaze()[i]);
        }
        
//        for(int j = 0; j < m.getDimension(); j++){
//            for(int k = 0; k < m.getDimension(); k++){
//                Room r = m.mazeBoard[j][k];
//                System.out.println(Arrays.toString(r.getDirections()[k]));
//            }
//        }
//        
        
        
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
        System.out.println(r.containsDirection("E"));
        
        while(!m.isGameOver()){
        	char move = sc.next().charAt(0);
        	if((move == 'N'|| move == 'n')&&(r.containsDirection("N"))){
        		play.movePosition(m, move);
        	}
        	else if((move == 'S' || move == 's')&& (r.containsDirection("S"))){
        		play.movePosition(m, move);
        	}
        	else if((move == 'E' || move == 'e')&&(r.containsDirection("E"))){
        		play.movePosition(m, move);
        	}
        	else if((move == 'W' || move == 'w')&&(r.containsDirection("W"))){
        		play.movePosition(m,move);
        	}
        	else{
        		System.out.println("I'm sorry, that's not a valid move. Please try again.");
        		continue;
        	}
        }
        
        
    }
}