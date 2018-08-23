

public class KingPiece extends Piece {

	KingPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList valid_moves(Board board) {
		LocationList moves = new LocationList();
		File file_minus_one = location.file.getPrev();
		File file_plus_one = location.file.getNext();
		
		int rank_plus_one = location.rank + 1;
		int rank_minus_one = location.rank - 1;
		
		Location temp_location = null;
		if(file_minus_one != null){
			temp_location = new Location(file_minus_one, rank_plus_one);
			if(rank_plus_one > 0 && rank_plus_one < 9 && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_minus_one, rank_minus_one);
			if(rank_minus_one > 0 && rank_minus_one < 9 && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_minus_one, location.rank);
			if(board.isVacantAt(temp_location) || board.canCapture(this, temp_location))
				moves.add(temp_location);
		}
		
		if(file_plus_one != null){
			temp_location = new Location(file_plus_one, rank_plus_one);
			if(rank_plus_one > 0 && rank_plus_one < 9 && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_plus_one, rank_minus_one);
			if(rank_minus_one > 0 && rank_minus_one < 9 && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_plus_one, location.rank);
			if(board.isVacantAt(temp_location) || board.canCapture(this, temp_location))
				moves.add(temp_location);
		}
		
		temp_location = new Location(location.file, rank_plus_one);
		if(rank_plus_one > 0 && rank_plus_one < 9 && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
			moves.add(temp_location);
		
		temp_location = new Location(location.file, rank_minus_one);
		if(rank_minus_one > 0 && rank_minus_one < 9 && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
			moves.add(temp_location);
		
		return moves;
	}
	
//	@Override
	public String toString(){
		return "K";
	}

}
