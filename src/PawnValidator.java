import java.util.ArrayList;

public class PawnValidator extends Validator {

	public PawnValidator(Board board, Piece piece) {
		super(board, piece);
	}

	@Override
	public ArrayList<Location> validate() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		for(Location location: piece.valid_moves()){
			if (board.is_vacant_at(location))
				valid_moves.add(location);
		}
		//check if there is a piece to be capture
		int rank = -1;
		//TODO add boarder checking here
		if(piece.color == Color.BLACK)
			rank = piece.location.rank - 1;
		
		if(piece.color == Color.WHITE)
			rank = piece.location.rank + 1;
		
		File first_diagonal = piece.location.file.getPrev();
		File second_diagonal = piece.location.file.getNext();
		
		if(first_diagonal != null && !board.is_vacant_at(new Location(first_diagonal, rank)) && board.can_capture(piece, new Location(first_diagonal, rank)))
			valid_moves.add(new Location(piece.location.file.getPrev(), rank));
		
		if(second_diagonal != null && !board.is_vacant_at(new Location(second_diagonal, rank)) && board.can_capture(piece, new Location(second_diagonal, rank)))
			valid_moves.add(new Location(piece.location.file.getNext(), rank));
		
		return valid_moves;
	}

}
