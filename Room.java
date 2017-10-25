import java.util.*;

public class Room{
    public int exits;
    private String[] directions;
    public int orientation;
    final String[] orientation1 = {"North", "East", "South", "West"};
    final String[] orientation2 = {"East", "South", "West", "North"};
    final String[] orientation3 = {"South", "West", "North", "East"};
    final String[] orientation4 = {"West", "North", "East", "South"};
        
    public Room(int exits, int orientation){
        this.exits = exits;
        this.orientation = orientation;
        this.setDirections();
    }

    // finds all the directions the user can move towards in this room
    private void setDirections(){
        //orientation can only be either 1, 2, 3, 4, or 5, 6
        //if it is 5, there are two exits at North and South
        //if it is 6, there are two exits at East and West
        if (exits == 0){
            return;
        }
        this.directions = new String[exits];
        switch(this.orientation){
            case 1:
                for(int i = 0; i < exits; i++){
                    directions[i] = orientation1[i];
                }
                break;
            case 2:
                for(int i = 0; i < exits; i++){
                    directions[i] = orientation2[i];
                }
                break;
            case 3:
                for(int i = 0; i < exits; i++){
                    directions[i] = orientation3[i];
                }
                break;
            case 4:
                for(int i = 0; i < exits; i++){
                    directions[i] = orientation4[i];
                }
                break;
            case 5:
                directions[0] = "North";
                directions[1] = "South";
                break;
            case 6:
                directions[0] = "East";
                directions[1] = "West";
                break;
        }
    }

    // returns an array that holds all of the directions the user can move towards in this room
    public String[] getDirections(){
        return directions;	
    }
    // returns true or false based on if the input string is in directions
    public boolean containsDirection(String c){
        List<String> list = Arrays.asList(this.getDirections());
        if(list.contains(c)){
            return true;
        }
        return false;
    }
    // returns the orientation of the room
    public int getOrientation(){
    	return this.orientation;
    }

    // will use the directions[] array to draw the rooms in ascii
    public void drawRoom(){
        switch(exits){
            case 0:
                System.out.println("+--------------------------+");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("+--------------------------+");
                break;
            case 1:
                switch(orientation){
                    case 1:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                    case 2:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                    case 3:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                    case 4:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                        
                }
                break;
            case 2:
                switch(orientation){
                    case 1:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                    case 2:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                    case 3:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                     case 4:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                    case 5:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                    case 6:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                }
                break;
            case 3:
                switch(orientation){
                    case 1:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                           ");
                        System.out.println("|                           ");
                        System.out.println("|                           ");
                        System.out.println("|                           ");
                        System.out.println("|                           ");
                        System.out.println("|                           ");
                        System.out.println("|                           ");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                    case 2:
                        System.out.println("+--------------------------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                    case 3:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("                           |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+-------            -------+");
                        break;
                    case 4:
                        System.out.println("+-------            -------+");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("                           ");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("|                          |");
                        System.out.println("+--------------------------+");
                        break;
                }   
                break; 
            case 4:
                System.out.println("+-------            -------+");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("                           ");
                System.out.println("                           ");
                System.out.println("                           ");
                System.out.println("                           ");
                System.out.println("                           ");
                System.out.println("                           ");
                System.out.println("                           ");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("|                          |");
                System.out.println("+-------            -------+");
                break;
        }   
    }
}