import java.util.*;
import java.io.*; 

public class MazeFactory{
    private Maze maze;
    private Scanner s;
    public String[] map;
    public String file;
    final String[] orientation1 = {"North", "East", "South", "West"};
    final String[] orientation2 = {"East", "South", "West", "North"};
    final String[] orientation3 = {"South", "West", "North", "East"};
    final String[] orientation4 = {"West", "North", "East", "South"};
    final String[][] allOrientation = {orientation1, orientation2, orientation3, orientation4};

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

    public boolean equalArray(ArrayList<String> one, ArrayList<String> two){     
        if (one == null && two == null){
            return true;
        }
    
        if((one == null && two != null) || one != null && two == null || one.size() != two.size()){
            return false;
        }
        ArrayList<String> oneTemp = new ArrayList<String>(one); 
        ArrayList<String> twoTemp = new ArrayList<String>(two);   
    
        Collections.sort(oneTemp);
        Collections.sort(twoTemp);      
        return oneTemp.equals(twoTemp);
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
                int orientation = 1;
                ArrayList<String> dir = new ArrayList<String>();
                if(Integer.parseInt(currentRow.substring(j,j+1)) == 1){
                    // north neighbor
                    if(nRow && !(nextRow.equals(empty))){
                        if(Integer.parseInt(nextRow.substring(j,j+1)) == 1){
                            exitCount++;
                            dir.add("North");
                        }
                    }
                    // east neighbor
                    if(j != (maze.getDimension() - 1) && Integer.parseInt(currentRow.substring(j+1,j+2)) == 1){
                        exitCount++;
                        dir.add("East");
                    }
                    // south neighbor
                    if(prevRow && !(previousRow.equals(empty))){
                        if(Integer.parseInt(previousRow.substring(j,j+1)) == 1 ){
                            exitCount++;
                            dir.add("South");
                        }
                    }
                    // west neighbor
                    if(j != 0 && Integer.parseInt(currentRow.substring(j-1,j)) == 1){
                        exitCount++;
                        dir.add("West");
                    }
                    for(int n = 0; n < allOrientation.length; n++){
                        String[] tempArray = Arrays.copyOfRange(allOrientation[n], 0, exitCount);
                        ArrayList<String> tempArrayList = new ArrayList<String>(Arrays.asList(tempArray));
                        if(this.equalArray(dir, tempArrayList)){
                            orientation = i + 1;
                        }
                        else if (exitCount == 2){
                            if(dir.contains("North")){
                                orientation = 5;
                            }
                            else{
                                orientation = 6;
                            }
                        }
                    }
                    //System.out.println("The number of exits for [" + i + "," + j + "] is " + exitCount);
                    maze.mazeBoard[i][j] = new Room(exitCount, orientation);
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