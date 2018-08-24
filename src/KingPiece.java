

public class KingPiece extends Piece {

	KingPiece(Color color, File file, Rank rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
		File file_minus_one = location.file.getPrev();
		File file_plus_one = location.file.getNext();
		
		Rank rank_plus_one = location.rank.getNext();
		Rank rank_minus_one = location.rank.getPrev();
		
		Location temp_location = null;
		if(file_minus_one != null){
			temp_location = new Location(file_minus_one, rank_plus_one);
			if(rank_plus_one != null && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_minus_one, rank_minus_one);
			if(rank_minus_one != null && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_minus_one, location.rank);
			if(board.isVacantAt(temp_location) || board.canCapture(this, temp_location))
				moves.add(temp_location);
		}
		
		if(file_plus_one != null){
			temp_location = new Location(file_plus_one, rank_plus_one);
			if(rank_plus_one != null && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_plus_one, rank_minus_one);
			if(rank_minus_one != null && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
				moves.add(temp_location);
			
			temp_location = new Location(file_plus_one, location.rank);
			if(board.isVacantAt(temp_location) || board.canCapture(this, temp_location))
				moves.add(temp_location);
		}
		
		temp_location = new Location(location.file, rank_plus_one);
		if(rank_plus_one != null && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
			moves.add(temp_location);
		
		temp_location = new Location(location.file, rank_minus_one);
		if(rank_minus_one != null && (board.isVacantAt(temp_location) || board.canCapture(this, temp_location)))
			moves.add(temp_location);
		
		return moves;
	}
	
//	@Override
	public String toString(){
		return "K";
	}

}
