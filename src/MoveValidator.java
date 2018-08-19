

public class MoveValidator {
	private Board board;
	private Piece piece;
	private Validator validator;
	private LocationList moves;
	
	public MoveValidator(Board board, Piece piece){
		this.board = board;
		this.piece = piece;
		validator = chooseValidator();
	}
	
	public LocationList validate(){
		moves = validator.validate();
		return moves;
	}
	
	public LocationList moves_that_cannot_lead_to_check(){
		LocationList valid_moves = new LocationList();

		for(Location location: validator.validate()){
			if(!(board.will_lead_to_check(piece, location)))
				valid_moves.add(location);
		}
		return valid_moves;
	}
	
	private Validator chooseValidator(){
		if(piece instanceof PawnPiece)
			return new PawnValidator(board, piece);
		
		if(piece instanceof KnightPiece)
			return new KnightValidator(board, piece);
		
		if(piece instanceof RookPiece)
			return new RookValidator(board, piece);
		
		if(piece instanceof BishopPiece)
			return new BishopValidator(board, piece);
		
		if(piece instanceof QueenPiece)
			return new QueenValidator(board, piece);
		
		if(piece instanceof KingPiece)
			return new KingValidator(board, piece);
		
		return null;
	}
}
