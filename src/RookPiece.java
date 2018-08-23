

public class RookPiece extends Piece {

	RookPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList valid_moves(Board board) {
		
		LocationList horizontal_moves = new LocationList();
		LocationList vertical_moves = new LocationList();
		
		LocationList moves = new LocationList();
		
		Location temp_location = null;
		
		//movement along the ranks
		for(int i =1; i<= 8; i++){
			if(location.rank == i)
				continue;
			
			temp_location = new Location(location.file, i);
			
			if(board.isVacantAt(temp_location))
				vertical_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(i < location.rank){
					vertical_moves.clear();
					vertical_moves.add(temp_location);
				} else {
					vertical_moves.add(temp_location);
					break;
				}
			} else {
				if(i < location.rank){
					vertical_moves.clear();
				} else {
					break;
				}
			}
		}
		
		//movement along the files
		File file = File.A;
		while(file != null){
			if(location.file == file){
				file = file.getNext();
				continue;
			}
			
			temp_location = new Location(file, location.rank);
			
			if(board.isVacantAt(temp_location))
				horizontal_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(file.ordinal() < location.file.ordinal()){
					horizontal_moves.clear();
					horizontal_moves.add(temp_location);
				} else {
					horizontal_moves.add(temp_location);
					break;
				}
			} else {
				if(file.ordinal() < location.file.ordinal()){
					horizontal_moves.clear();
				} else {
					break;
				}
			}
			
			file = file.getNext();
		}
		
//		moves.addAll(horizontal_moves);
		for(Location location: horizontal_moves)
			moves.add(location);
		for(Location location: vertical_moves)
			moves.add(location);
		return moves;
	}
	
	public String toString(){
		return "R";
	}

}
