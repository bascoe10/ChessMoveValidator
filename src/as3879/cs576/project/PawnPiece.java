package as3879.cs576.project;


public class PawnPiece extends Piece {

	PawnPiece(Color color, File file, Rank rank) {
		super(color, file, rank);
	}

	@Override
	public LocationList validMoves(Board board) {
		
		Location temp_location = null;
		if(color == Color.WHITE){
			temp_location = new Location(this.location.file, this.location.rank.getNext());
			if(board.isVacantAt(temp_location))
				moves.add(temp_location);
			//special first move
			temp_location = new Location(this.location.file, Rank.TWO);
			if(this.location.rank == Rank.TWO)
				moves.add(temp_location);
			//capture piece in diagonal
			temp_location = new Location(this.location.file.getPrev(), this.location.rank.getNext());
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
			
			temp_location = new Location(this.location.file.getNext(), this.location.rank.getNext());
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
			
		} else {
			temp_location = new Location(this.location.file, this.location.rank.getPrev());
			if(board.isVacantAt(temp_location))
				moves.add(temp_location);
			temp_location = new Location(this.location.file, Rank.SEVEN);
			if(this.location.rank == Rank.SEVEN)
				moves.add(temp_location);
			
			//capture piece in diagonal
			temp_location = new Location(this.location.file.getPrev(), this.location.rank.getPrev());
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
			
			temp_location = new Location(this.location.file.getNext(), this.location.rank.getPrev());
			if(board.canCapture(this, temp_location))
				moves.add(temp_location);
		}
		return moves;
	}
	
	public String toString(){
		return "P";
	}

}
