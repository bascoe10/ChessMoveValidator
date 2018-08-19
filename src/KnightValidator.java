

public class KnightValidator extends Validator {

	public KnightValidator(Board board, Piece piece) {
		super(board, piece);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LocationList validate() {
		return piece.valid_moves(board);
	}

}
