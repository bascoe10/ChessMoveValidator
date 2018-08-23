

public class BishopPiece extends Piece {

	BishopPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocationList valid_moves(Board board) {
		LocationList moves = new LocationList();
		
		// to top right
		File file = location.file.getNext();
		int temp_rank = location.rank + 1;
		Location temp_location = null;
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (validRank(temp_rank)){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getNext();
			temp_rank += 1;
		}
		// to bottom left
		file = location.file.getPrev();
		temp_rank = location.rank - 1;
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (validRank(temp_rank)){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getPrev();
			temp_rank -= 1;
		}

		file = location.file.getNext();
		temp_rank = location.rank - 1;
		// to bottom right
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (validRank(temp_rank)){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getNext();
			temp_rank -= 1;
		}

		file = location.file.getPrev();
		temp_rank = location.rank + 1;
		// to top left
		while (file != null) {
			temp_location = new Location(file, temp_rank);
			if (validRank(temp_rank)){
				if(board.isVacantAt(temp_location))
					moves.add(new Location(file, temp_rank));
				else if(board.canCapture(this, temp_location)){
					moves.add(new Location(file, temp_rank));
					break;
				} else {
					break;
				}
					
			}
			file = file.getPrev();
			temp_rank += 1;
		}

		return moves;
	}

	public String toString() {
		return "B";
	}

}
