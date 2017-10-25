import java.util.*;

public class Maze{
    private int dimension;
    private MazeFactory mFactory;
    public Room[][] mazeBoard;
    public Player play;
    public int x;
    public int y;
    public String file;
    public boolean gameOver;
    public LinkedList<String> gameLog = new LinkedList<String>();

    // Takes in a dimension of the maze and the path to the text file that contains the layout of the maze
    public Maze(int size, String f){
        this.dimension = size;
        this.file = f;
        this.mazeBoard = new Room[dimension][dimension];
        mFactory = new MazeFactory(this);
        mFactory.makeMaze();
        this.gameOver = false;
    }
    
    // Returns the dimension of the maze
    public int getDimension(){
        return dimension;
    }

    // Returns a boolean that represents if the game is over or not
    public boolean isGameOver(){
        if(this.getX() == (this.getDimension()-1) && this.getY() == (this.getDimension()-1)){
            return true;
        }
        else{
            return false;
        }
    }

    // Returns the array that contains string inputs from the maze file
    public String[] getMaze(){
        return mFactory.map;
    }
    
    public void drawMazeRoom(){
    	mazeBoard[this.x][this.y].drawRoom(); 
    }
    public int getX(){
    	return this.x;
    }
    
    public int getY(){
    	return this.y;
    }
    
    public void setX(int x){
    	this.x = x;
    }
    
    public void setY(int y){
    	this.y = y;
    }
    
    
}