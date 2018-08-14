import java.util.ArrayList;

public class KingValidator extends Validator {

	public KingValidator(Board board, Piece piece) {
		super(board, piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> validate() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		for(Location location: piece.valid_moves()){
			if(board.is_vacant_at(location) || board.can_capture(piece, location))
				valid_moves.add(location);
		}
		return valid_moves;
	}

}
