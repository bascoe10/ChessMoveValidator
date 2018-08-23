

public class PawnValidator extends Validator {

	public PawnValidator(Board board, Piece piece) {
		super(board, piece);
	}

	@Override
	public LocationList validate() {
//		ArrayList<Location> valid_moves = new ArrayList<Location>();
//		for(Location location: piece.valid_moves(board)){
//			if (board.isVacantAt(location))
//				valid_moves.add(location);
//		}
//		//check if there is a piece to be capture
//		int rank = -1;
//		//TODO add boarder checking here
//		if(piece.color == Color.BLACK)
//			rank = piece.location.rank - 1;
//		
//		if(piece.color == Color.WHITE)
//			rank = piece.location.rank + 1;
//		
//		File first_diagonal = piece.location.file.getPrev();
//		File second_diagonal = piece.location.file.getNext();
//		
//		if(first_diagonal != null && !board.isVacantAt(new Location(first_diagonal, rank)) && board.canCapture(piece, new Location(first_diagonal, rank)))
//			valid_moves.add(new Location(piece.location.file.getPrev(), rank));
//		
//		if(second_diagonal != null && !board.isVacantAt(new Location(second_diagonal, rank)) && board.canCapture(piece, new Location(second_diagonal, rank)))
//			valid_moves.add(new Location(piece.location.file.getNext(), rank));
		
		return piece.valid_moves(board);
	}

}
