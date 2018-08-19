

public class PawnPiece extends Piece {

	PawnPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList valid_moves(Board board) {
		// TODO account handle special move
		LocationList moves = new LocationList();
		
		Location temp_location = null;
		if(color == Color.WHITE){
			temp_location = new Location(this.location.file, this.location.rank-1);
			if(board.is_vacant_at(temp_location))
				moves.add(temp_location);
		} else {
			temp_location = new Location(this.location.file, this.location.rank+1);
			if(board.is_vacant_at(temp_location))
				moves.add(temp_location);
		}
			
		// TODO account for capture move
		return moves;
	}
	
	public String toString(){
		return "P";
	}

}
