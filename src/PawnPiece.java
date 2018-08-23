

public class PawnPiece extends Piece {

	PawnPiece(Color color, File file, Rank rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
		// TODO account handle special move
		LocationList moves = new LocationList();
		
		Location temp_location = null;
		if(color == Color.WHITE){
			temp_location = new Location(this.location.file, this.location.rank+1);
			if(board.isVacantAt(temp_location))
				moves.add(temp_location);
			//special first move
			temp_location = new Location(this.location.file, this.location.rank+2);
			if(this.location.rank == 2)
				moves.add(temp_location);
			//capture piece in diagonal
			temp_location = new Location(this.location.file.getPrev(), this.location.rank+1);
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
			
			temp_location = new Location(this.location.file.getNext(), this.location.rank+1);
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
			
		} else {
			temp_location = new Location(this.location.file, this.location.rank-1);
			if(board.isVacantAt(temp_location))
				moves.add(temp_location);
			temp_location = new Location(this.location.file, this.location.rank-2);
			if(this.location.rank == 7)
				moves.add(temp_location);
			
			//capture piece in diagonal
			temp_location = new Location(this.location.file.getPrev(), this.location.rank-1);
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
			
			temp_location = new Location(this.location.file.getNext(), this.location.rank-1);
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
		}
		return moves;
	}
	
	public String toString(){
		return "P";
	}

}
