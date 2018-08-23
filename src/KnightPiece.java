

public class KnightPiece extends Piece {

	KnightPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
		LocationList moves = new LocationList();
		
		int rank_plus_two = location.rank + 2;
		int rank_plus_one = location.rank + 1;
		int rank_minus_two = location.rank - 2;
		int rank_minus_one = location.rank - 1;
		
		File file_plus_one = location.file.getNext();
		File file_plus_two = null;
		if(file_plus_one != null)
			file_plus_two = file_plus_one.getNext();
		
		File file_minus_one = location.file.getPrev();
		File file_minus_two = null;
		if(file_minus_one != null)
			file_minus_two = file_minus_one.getNext();
		
		Location temp_location = null;
		if(file_minus_one != null){
			temp_location = new Location(file_minus_one, rank_minus_two);
			if(validRank(rank_minus_two) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_minus_one, rank_plus_two);
			if(validRank(rank_plus_two) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
		}
		
		if(file_minus_two != null){
			temp_location = new Location(file_minus_two, rank_plus_one);
			if(validRank(rank_plus_one) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_minus_two, rank_minus_one);
			if(validRank(rank_minus_one) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
		}
		
		if(file_plus_one != null){
			temp_location = new Location(file_plus_one, rank_minus_two);
			if(validRank(rank_minus_two) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_plus_one, rank_plus_two);
			if(validRank(rank_plus_two) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
		}
		
		if(file_plus_two != null){
			temp_location = new Location(file_plus_two, rank_plus_one);
			if(validRank(rank_plus_one) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_plus_two, rank_minus_one);
			if(validRank(rank_minus_one) && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
		}
		
		
		return moves;
	}
	
	public String toString(){
		return "N";
	}

}
