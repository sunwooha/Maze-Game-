import java.util.*;

public class Main{

    public static void main(String argv[]){

        /*Random rand = new Random();
        int exit = rand.nextInt(4) + 1;
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
        j.drawRoom();*/
        String level0 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level0.txt";
        String level1 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level1.txt";
        Maze m = new Maze(12, level1);
        for(int i = 0; i < m.getDimension(); i++){
            System.out.println(m.getMaze()[i]);
        }
    }
}