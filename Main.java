import java.util.*;

public class Main{

    public static void main(String argv[]){

        Random rand = new Random();
        int exit = rand.nextInt(4) + 1;
        System.out.println("This is the original exit number: " + exit);
        int orientation = rand.nextInt(6) + 1;
        Room j = new Room(exit, orientation);
        if (orientation == 5 || orientation == 6){
            j.exits = 2;
            j = new Room(2, orientation);
        }
        String[] directions = j.whichDir();
        for(int i = 0; i < directions.length; i++){
            System.out.print(directions[i] + ", ");
        }
        System.out.println("There should be " + j.exits + " exits and the orientation is " + orientation);
        j.drawRoom();
        /*String level0 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level0.txt";
        String level1 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level1.txt";
        String level2 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level2.txt";
        Maze m = new Maze(12, level2);
        for(int i = 0; i < m.getDimension(); i++){
            System.out.println(m.getMaze()[i]);
        }*/
    }
}