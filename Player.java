public abstract class Player {
	
	// Takes a char of N, S, E or W to move the player
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

	// abstract function to get the char for movePosition
	abstract public char getMove(Maze m);
}
