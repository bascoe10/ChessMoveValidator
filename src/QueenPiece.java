

public class QueenPiece extends Piece {

	QueenPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
		

		LocationList horizontal_moves = new LocationList();
		LocationList vertical_moves = new LocationList();

		LocationList moves = new LocationList();
		
		// Diagonal motion
		
		// to top right
		File file = location.file.getNext();
		int temp_rank = location.rank + 1;
		Location temp_location = null;
		
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank > 0 && temp_rank < 9){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getNext();
			temp_rank += 1;
		}
		// to bottom left
		file = location.file.getPrev();
		temp_rank = location.rank - 1;
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank > 0 && temp_rank < 9){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getPrev();
			temp_rank -= 1;
		}

		file = location.file.getNext();
		temp_rank = location.rank - 1;
		// to bottom right
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank > 0 && temp_rank < 9){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getNext();
			temp_rank -= 1;
		}

		file = location.file.getPrev();
		temp_rank = location.rank + 1;
		// to top left
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank > 0 && temp_rank < 9){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getPrev();
			temp_rank += 1;
		}

		
		//axis motion
		
		for(int i =1; i<= 8; i++){
			if(location.rank == i){
				continue;
			}
			
			temp_location = new Location(location.file, i);
			
			if(board.isVacantAt(temp_location))
				vertical_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(i < location.rank){
					vertical_moves.clear();
					vertical_moves.add(temp_location);
				} else {
					vertical_moves.add(temp_location);
					break;
				}
			} else {
				if(i < location.rank){
					vertical_moves.clear();
				} else {
					break;
				}
			}
		}
		
		
		file = File.A;
		while(file != null){
			if(location.file == file){
				file = file.getNext();
				continue;
			}
			
			temp_location = new Location(file, location.rank);
			
			if(board.isVacantAt(temp_location))
				horizontal_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(file.ordinal() < location.file.ordinal()){
					horizontal_moves.clear();
					horizontal_moves.add(temp_location);
				} else {
					horizontal_moves.add(temp_location);
					break;
				}
			} else {
				if(file.ordinal() < location.file.ordinal()){
					horizontal_moves.clear();
				} else {
					break;
				}
			}
			
			file = file.getNext();
		}
		
		for(Location location: horizontal_moves)
			moves.add(location);
		for(Location location: vertical_moves)
			moves.add(location);
		
		return moves;
	}
	
	
	public String toString(){
		return "Q";
	}

}
