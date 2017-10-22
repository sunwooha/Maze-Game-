public class Room{
    public int exits;
    private String[] directions;
    private boolean playerHere;
    private boolean visited;
    private int orientation;
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

    public void putPlayerHere(){
        playerHere = true;
        visited = true;
    }

    public void playerLeaves(){
        playerHere = false;
    }

    public boolean isPlayerHere(){
        return playerHere;
    }

    private void setDirections(){
        //orientation can only be either 1, 2, 3, 4, or 5, 6
        //if it is 5, there are two exits at North and South
        //if it is 6, there are two exits at East and West
        this.directions = new String[exits];
        switch(this.orientation){
            case 1:
                for(int i = exits - 1; i < exits; i++){
                    directions[i] = orientation1[i];
                }
            case 2:
                for(int i = exits - 1; i < exits; i++){
                    directions[i] = orientation2[i];
                }
            case 3:
                for(int i = exits - 1; i < exits; i++){
                    directions[i] = orientation3[i];
                }
            case 4:
                for(int i = exits - 1; i < exits; i++){
                    directions[i] = orientation4[i];
                }
            case 5:
                directions[0] = "North";
                directions[1] = "South";
            case 6:
                directions[0] = "East";
                directions[1] = "West";
        }
    }

    public String[] whichDir(){
        return directions;
    }

    public boolean hasVisited(){
        return visited;
    }

    public void drawRoom(){
        //will use the directions[] array to draw the rooms in ascii
        switch(exits){
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
                        
                }
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
                }
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
                }    
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
        }   
    }
}