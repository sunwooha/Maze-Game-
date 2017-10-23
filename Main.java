import java.util.*;

public class Main{

    public static void main(String argv[]){
        String level0 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level0.txt";
        String level1 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level1.txt";
        String level2 = "/Users/jenniferha/Documents/New College/3rd Year/Fall 2017/Object Oriented Design/MazeGame/level2.txt";
        Maze m = new Maze(12, level0);
        for(int i = 0; i < m.getDimension(); i++){
            System.out.println(m.getMaze()[i]);
        }
        for(int j = 0; j < m.getDimension(); j++){
            for(int k = 0; k < m.getDimension(); k++){
                Room r = m.mazeBoard[j][k];
                r.drawRoom();
            }
        }
    }
}