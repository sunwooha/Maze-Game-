
public abstract class Player {
	
	public void movePosition(Maze m, char there){
		int currentX = m.getX();
		int currentY = m.getY();
		int targetX;
		int targetY;
		
		if(!m.isGameOver()){
			if(there == 'N' || there == 'n'){
				targetX = currentX - 1;
				m.mazeBoard[targetX][currentY].drawRoom();
				currentX = targetX;
			}
			else if(there == 'S' || there == 's'){
				targetX = currentX + 1;
				m.mazeBoard[targetX][currentY].drawRoom();
				currentX = targetX;
			}
			else if(there == 'E' || there == 'e'){
				targetY = currentY + 1;
				m.mazeBoard[currentX][targetY].drawRoom();
				currentY = targetY;				
			}
			else if(there == 'W' || there == 'w'){
				targetY = currentY - 1; 
				m.mazeBoard[currentX][targetY].drawRoom();
				currentY = targetY;
			}
		}
		m.setX(currentX);
		m.setY(currentY);
	}
	abstract public char getMove(Maze m);
}
