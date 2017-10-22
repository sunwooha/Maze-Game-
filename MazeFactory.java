import java.util.*;
import java.io.*; 

public class MazeFactory{
    private Maze maze;
    private Scanner s;
    public String[] map;
    public String file;

    // Takes in a maze object
    public MazeFactory(Maze m){
        this.maze = m;
    }

    // Opens the text file that contains the layout of the map
    private void openFile(){
        try{
            s = new Scanner(new File(maze.file));
        }
        catch(Exception e){
            System.out.println("Error loading the Maze");
        }
    }

    // Reads all of the input from the file and then fills the array
    private void readFile(){
        map = new String[maze.getDimension()];
        while(s.hasNext()){
            for(int i = 0; i < maze.getDimension(); i++){
                map[i] = s.next();
            }
        }
    }

    // Closes the scanner
    private void closeFile(){
        s.close();
    }

    // Creates the maze by getting the input maze layout and making a Room object for each 1 or 0
    public void makeMaze(){
        this.openFile();
        this.readFile();
        this.closeFile();
        for(int i = 0; i < maze.getDimension(); i++){
            String previousRow = "";
            String nextRow = "";
            boolean prevRow = false;
            boolean nRow = false;
            String currentRow = map[i];
            String empty = "";
            if (i > 0){
                previousRow = map[i-1];
                prevRow = true;
            }
            if (i < maze.getDimension() - 1){
                nextRow = map[i+1];
                nRow = true;
            }
            for(int j = 0; j < maze.getDimension(); j++){
                int exitCount = 0;
                if(Integer.parseInt(currentRow.substring(j,j+1)) == 1){
                    // east neighbor
                    if(j != (maze.getDimension() - 1) && Integer.parseInt(currentRow.substring(j+1,j+2)) == 1){
                        exitCount++;
                    }
                    // west neighbor
                    if(j != 0 && Integer.parseInt(currentRow.substring(j-1,j)) == 1){
                        exitCount++;
                    }
                    // south neighbor
                    if(prevRow && !(previousRow.equals(empty))){
                        if(Integer.parseInt(previousRow.substring(j,j+1)) == 1 ){
                            exitCount++;
                        }
                    }
                    // north neighbor
                    if(nRow && !(nextRow.equals(empty))){
                        if(Integer.parseInt(nextRow.substring(j,j+1)) == 1){
                            exitCount++;
                        }
                    }
                    System.out.println("The number of exits for [" + i + "," + j + "] is " + exitCount);
                    //maze.mazeBoard[i][j] = new Room(exitCount, );
                }
                //there needs to be a null room...
                else{ 
                    //maze.mazeBoard[i][j] = new Room(exitCount, );
                    System.out.println("This is a null room");
                }
            }
        }
    }
}