package as3879.cs576.project;


public class QueenPiece extends Piece {

	QueenPiece(Color color, File file, Rank rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
		diagonalMoves(board);

		axisMoves(board);
		
		return moves;
	}
	
	
	public String toString(){
		return "Q";
	}
	
	private void axisMoves(Board board){
		//axis motion
		LocationList horizontal_moves = new LocationList();
		LocationList vertical_moves = new LocationList();
		Location temp_location = null;
		File file = null;
		Rank rank = Rank.ONE;
		while(rank != null){
			if(location.rank == rank){
				rank = rank.getNext();
				continue;
			}
			
			temp_location = new Location(location.file, rank);
			
			if(board.isVacantAt(temp_location))
				vertical_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(rank.lessThan(location.rank)){
					vertical_moves.clear();
					vertical_moves.add(temp_location);
				} else {
					vertical_moves.add(temp_location);
					break;
				}
			} else {
				if(rank.lessThan(location.rank)){
					vertical_moves.clear();
				} else {
					break;
				}
			}
			rank = rank.getNext();
		}
		
		
		file = File.A;
		while(file != null){
			if(location.file == file){
				file = file.getNext();
				continue;
			}
			
			temp_location = new Location(file, location.rank);
			
			if(board.isVacantAt(temp_location))
				horizontal_moves.add(temp_location);
			else if(board.canCapture(this, temp_location)){
				if(file.lessThan(location.file)){
					horizontal_moves.clear();
					horizontal_moves.add(temp_location);
				} else {
					horizontal_moves.add(temp_location);
					break;
				}
			} else {
				if(file.lessThan(location.file)){
					horizontal_moves.clear();
				} else {
					break;
				}
			}
			
			file = file.getNext();
		}
		
		for(Location location: horizontal_moves)
			moves.add(location);
		for(Location location: vertical_moves)
			moves.add(location);
	}
	
	private void diagonalMoves(Board board){
		// Diagonal motion
		
		// to top right
		File file = location.file.getNext();
		Rank temp_rank = location.rank.getNext();
		Location temp_location = null;
		
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank != null){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
				temp_rank = temp_rank.getNext();	
			}
			file = file.getNext();
		}
		// to bottom left
		file = location.file.getPrev();
		temp_rank = location.rank.getPrev();
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank != null){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
				temp_rank = temp_rank.getPrev();
			}
			file = file.getPrev();
		}

		file = location.file.getNext();
		temp_rank = location.rank.getPrev();
		// to bottom right
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank != null){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
				temp_rank = temp_rank.getPrev();
			}
			file = file.getNext();
		}

		file = location.file.getPrev();
		temp_rank = location.rank.getNext();
		// to top left
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (temp_rank != null){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
				temp_rank = temp_rank.getNext();
			}
			file = file.getPrev();
		}
	}

}
