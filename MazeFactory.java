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

    // Finds the orientation of the room
    private int findOrientation(ArrayList<String> a, int count){
        int orient = 0;
        for(int n = 0; n < allOrientation.length; n++){
            String[] tempArray = Arrays.copyOfRange(allOrientation[n], 0, count);
            ArrayList<String> tempArrayList = new ArrayList<String>(Arrays.asList(tempArray));
            Collections.sort(a);
            Collections.sort(tempArrayList); 
            if(a.equals(tempArrayList)){
                orient = n + 1;
                return orient;
            }
            else {
                if (a.contains("North")){
                    orient = 5;
                }
                else{
                    orient = 6;
                }
            }
        }
        return orient;
    }

    // Creates the maze by getting the input maze layout and making a Room object for each 1 or 0
    public void makeMaze(){
        this.openFile();
        this.readFile();
        this.closeFile();
        for(int i = 0; i < maze.getDimension(); i++){
            String currentRow = map[i];
            for(int j = 0; j < maze.getDimension(); j++){
                int exitCount = 0;
                int orientation = 0;
                ArrayList<String> dir = new ArrayList<String>();
                if(Integer.parseInt(currentRow.substring(j,j+1)) == 1){
                    // north neighbor
                    if(i != 0 && Integer.parseInt(map[i-1].substring(j,j+1)) == 1){
                        exitCount++;
                        dir.add("North");
                    }
                    // east neighbor
                    if(j != (maze.getDimension() - 1) && Integer.parseInt(currentRow.substring(j+1,j+2)) == 1){
                        exitCount++;
                        dir.add("East");
                    }
                    // south neighbor
                    if(i != (maze.getDimension() - 1) && Integer.parseInt(map[i+1].substring(j,j+1)) == 1){
                        exitCount++;
                        dir.add("South");
                    }
                    // west neighbor
                    if(j != 0 && Integer.parseInt(currentRow.substring(j-1,j)) == 1){
                        exitCount++;
                        dir.add("West");
                    }
                    orientation = findOrientation(dir, exitCount);
                    maze.mazeBoard[i][j] = new Room(exitCount, orientation);
                }
                else{ 
                    maze.mazeBoard[i][j] = new Room(0, 0);
                }
            }
        }
    }
}