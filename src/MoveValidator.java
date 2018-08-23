

public class MoveValidator {
	private Board board;
	private Piece piece;
	private Validator validator;
	private LocationList moves;
	
	public MoveValidator(Board board, Piece piece){
		this.board = board;
		this.piece = piece;
		validator = chooseValidator();
		moves = new LocationList();
	}
	
	public LocationList psuedoLegalMoves(){
		moves.clear();
		moves = validator.validate();
		return moves;
	}
	
	public LocationList legalMoves(){
		moves.clear();
		for(Location location: validator.validate()){
			if(!(board.will_lead_to_check(piece, location)))
				moves.add(location);
		}
		return moves;
	}
	
	private Validator chooseValidator(){
		if(piece instanceof PawnPiece)
			return new PawnValidator(board, piece);
		else if(piece instanceof KnightPiece)
			return new KnightValidator(board, piece);
		else if(piece instanceof RookPiece)
			return new RookValidator(board, piece);
		else if(piece instanceof BishopPiece)
			return new BishopValidator(board, piece);
		else if(piece instanceof QueenPiece)
			return new QueenValidator(board, piece);
		else if(piece instanceof KingPiece)
			return new KingValidator(board, piece);
		return null;
	}
}
