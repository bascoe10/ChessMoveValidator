import java.util.ArrayList;

public class RookValidator extends Validator {

	public RookValidator(Board board, Piece piece) {
		super(board, piece);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Location> validate() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
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
		
		return valid_moves;
	}

}
