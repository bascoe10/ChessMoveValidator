import java.util.ArrayList;

public class QueenValidator extends Validator {

	public QueenValidator(Board board, Piece piece) {
		super(board, piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> validate() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		boolean quad_1 = false;
		boolean quad_2 = false;
		boolean quad_3 = false;
		boolean quad_4 = false;
		ArrayList<Location> horizontal_moves = new ArrayList<Location>();
		ArrayList<Location> vertical_moves = new ArrayList<Location>();
		ArrayList<Location> temp = new ArrayList<Location>();
		
		for(Location location: piece.valid_moves()){
			if(location.file == piece.location.file)
				vertical_moves.add(location);
			if(location.rank == piece.location.rank)
				horizontal_moves.add(location);
		}
		
		for(Location location: vertical_moves){
			if(board.is_vacant_at(location)){
				temp.add(location);
			}else{
				if(board.can_capture(piece, location)){
					if(location.rank < piece.location.rank){
						temp.clear();
						temp.add(location);
					}else{
						temp.add(location);
						break;
					}
				}else{
					if(location.rank < piece.location.rank){
						temp.clear();
					}else{
						break;
					}
				}
			}
		}
		
		valid_moves.addAll(temp);
		temp.clear();
		
		for(Location location: horizontal_moves){
			if(board.is_vacant_at(location)){
				temp.add(location);
			}else{
				if(board.can_capture(piece, location)){
					if(location.file.ordinal() < piece.location.file.ordinal()){
						temp.clear();
						temp.add(location);
					}else{
						temp.add(location);
						break;
					}
				}else{
					if(location.file.ordinal() < piece.location.file.ordinal()){
						temp.clear();
					}else{
						break;
					}
				}
			}
		}
		
		valid_moves.addAll(temp);
		temp.clear();
		
		for(Location location: piece.valid_moves()){
			if(location.file.ordinal() > piece.location.file.ordinal() && location.rank > piece.location.rank && !quad_1){
				if(board.is_vacant_at(location))
					valid_moves.add(location);
				else if(board.can_capture(piece, location)){
					valid_moves.add(location);
					quad_1 = true;
				}else
					quad_1 = true;
				continue;
			}
			
			if(location.file.ordinal() < piece.location.file.ordinal() && location.rank > piece.location.rank && !quad_2){
				if(board.is_vacant_at(location))
					valid_moves.add(location);
				else if(board.can_capture(piece, location)){
					valid_moves.add(location);
					quad_2 = true;
				}else
					quad_2 = true;
				continue;
			}
			
			if(location.file.ordinal() < piece.location.file.ordinal() && location.rank < piece.location.rank && !quad_3){
				if(board.is_vacant_at(location))
					valid_moves.add(location);
				else if(board.can_capture(piece, location)){
					valid_moves.add(location);
					quad_3 = true;
				}else
					quad_3 = true;
				continue;
			}
			
			if(location.file.ordinal() > piece.location.file.ordinal() && location.rank < piece.location.rank && !quad_4){
				if(board.is_vacant_at(location))
					valid_moves.add(location);
				else if(board.can_capture(piece, location)){
					valid_moves.add(location);
					quad_4 = true;
				}else
					quad_4 = true;
				continue;
			}
			
			if(quad_1 && quad_2 && quad_3 && quad_4)
				break;
		}
		return valid_moves;
	}

}
