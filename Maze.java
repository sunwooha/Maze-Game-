import java.util.*;

public class Maze{
    private int dimension;
    private boolean gameOver;
    private MazeFactory mFactory;
    public Room[][] mazeBoard;
    public String file;
    public LinkedList<String> gameLog = new LinkedList<String>();

    // Takes in a dimension of the the maze and the path to the text file that contains the layout of the maze
    public Maze(int size, String f){
        this.dimension = size;
        this.file = f;
        this.mazeBoard = new Room[dimension][dimension];
        mFactory = new MazeFactory(this);
        mFactory.makeMaze();
    }
    
    // Returns the dimension of the maze
    public int getDimension(){
        return dimension;
    }

    // Returns a boolean that represents if the game is over or not
    public boolean isGameOver(){
        return gameOver;  
    }

    // Returns the array that contains string inputs from the maze file
    public String[] getMaze(){
        return mFactory.map;
    }

    // Adds the player onto the maze
    public void addPlayer(int x, int y){
        mazeBoard[x][y].putPlayerHere();
    }
}