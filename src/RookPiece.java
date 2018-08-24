

public class RookPiece extends Piece {

	RookPiece(Color color, File file, Rank rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
		
		//axis motion
		LocationList horizontal_moves = new LocationList();
		LocationList vertical_moves = new LocationList();
		Location temp_location = null;
		File file = null;
		Rank rank = Rank.ONE;
		while(rank != null){
			if(location.rank == rank){
				rank = rank.getNext();
				continue;
			}
			
			temp_location = new Location(location.file, rank);
			
			if(board.isVacantAt(temp_location))
				vertical_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(rank.lessThan(location.rank)){
					vertical_moves.clear();
					vertical_moves.add(temp_location);
				} else {
					vertical_moves.add(temp_location);
					break;
				}
			} else {
				if(rank.lessThan(location.rank)){
					vertical_moves.clear();
				} else {
					break;
				}
			}
			rank = rank.getNext();
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
				if(file.lessThan(location.file)){
					horizontal_moves.clear();
					horizontal_moves.add(temp_location);
				} else {
					horizontal_moves.add(temp_location);
					break;
				}
			} else {
				if(file.lessThan(location.file)){
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
		return "R";
	}

}
