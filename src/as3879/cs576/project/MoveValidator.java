package as3879.cs576.project;


public class MoveValidator {
	private Board board;
	private Piece piece;
	private LocationList moves;
	
	public MoveValidator(Board board, Piece piece){
		this.board = board;
		this.piece = piece;
		moves = new LocationList();
	}
	
	public LocationList psuedoLegalMoves(){
		moves.clear();
		moves = piece.validMoves(board);
		return moves;
	}
	
	public LocationList legalMoves(){
		moves.clear();
		for(Location location: piece.validMoves(board)){
			if(!(board.willLeadToCheck(piece, location)))
				moves.add(location);
		}
		return moves;
	}
}
