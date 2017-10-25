public class Room{
    public int exits;
    private String[] directions;
    private boolean playerHere;
    private boolean visited;
    public int orientation;
    final String[] orientation1 = {"North", "East", "South", "West"};
    final String[] orientation2 = {"East", "South", "West", "North"};
    final String[] orientation3 = {"South", "West", "North", "East"};
    final String[] orientation4 = {"West", "North", "East", "South"};

    public Room(int exits, int orientation){
        this.exits = exits;
        this.orientation = orientation;
        //orientation can be 1, 2, 3, 4, 5, or 6
        this.setDirections();
    }

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

    public String[] getDirections(){
        return directions;	
    }

    public boolean containsDirection(String c){
    	String value = c.toUpperCase();
    	for(int i = 0; i < (this.getDirections()).length; i++){
    		for(int j = 0; j < (this.getDirections()).length; j++){
    			System.out.println(this.getDirections()[j].substring(0, 1 ));
    			if(this.getDirections()[j].substring(0, 1).equals(value)){
    				return true;
    			}
    		} 		
    	}
    	return false;
    }
    
    public int getOrientation(){
    	return this.orientation;
    }

    public void drawRoom(){
        //will use the directions[] array to draw the rooms in ascii
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