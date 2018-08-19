

public class BishopValidator extends Validator {

	public BishopValidator(Board board, Piece piece) {
		super(board, piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validate() {
//		ArrayList<Location> valid_moves = new ArrayList<Location>();
//		boolean quad_1 = false;
//		boolean quad_2 = false;
//		boolean quad_3 = false;
//		boolean quad_4 = false;
//		
//		for(Location location: piece.valid_moves()){
//			if(location.file.ordinal() > piece.location.file.ordinal() && location.rank > piece.location.rank && !quad_1){
//				if(board.is_vacant_at(location))
//					valid_moves.add(location);
//				else if(board.can_capture(piece, location)){
//					valid_moves.add(location);
//					quad_1 = true;
//				}else
//					quad_1 = true;
//				continue;
//			}
//			
//			if(location.file.ordinal() < piece.location.file.ordinal() && location.rank > piece.location.rank && !quad_2){
//				if(board.is_vacant_at(location))
//					valid_moves.add(location);
//				else if(board.can_capture(piece, location)){
//					valid_moves.add(location);
//					quad_2 = true;
//				}else
//					quad_2 = true;
//				continue;
//			}
//			
//			if(location.file.ordinal() < piece.location.file.ordinal() && location.rank < piece.location.rank && !quad_3){
//				if(board.is_vacant_at(location))
//					valid_moves.add(location);
//				else if(board.can_capture(piece, location)){
//					valid_moves.add(location);
//					quad_3 = true;
//				}else
//					quad_3 = true;
//				continue;
//			}
//			
//			if(location.file.ordinal() > piece.location.file.ordinal() && location.rank < piece.location.rank && !quad_4){
//				if(board.is_vacant_at(location))
//					valid_moves.add(location);
//				else if(board.can_capture(piece, location)){
//					valid_moves.add(location);
//					quad_4 = true;
//				}else
//					quad_4 = true;
//				continue;
//			}
//			
//			if(quad_1 && quad_2 && quad_3 && quad_4)
//				break;
//		}
		return piece.valid_moves(board);
	}

}
