package cs576;


public class BishopPiece extends Piece {

	BishopPiece(Color color, File file, Rank rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList validMoves(Board board) {
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

		return moves;
	}

	public String toString() {
		return "B";
	}

}
