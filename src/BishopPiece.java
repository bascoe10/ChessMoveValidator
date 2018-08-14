
import java.util.ArrayList;

public class BishopPiece extends Piece {

	BishopPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> valid_moves(Board board) {
		ArrayList<Location> moves = new ArrayList<Location>();
		File file = location.file.getNext();
		int temp_rank = location.rank;
		// to top right
		while (file != null) {
			temp_rank += 1;
			if (temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getNext();
		}

		// to bottom left
		file = location.file.getPrev();
		temp_rank = location.rank;
		while (file != null) {
			temp_rank -= 1;
			if (temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getPrev();
		}

		file = location.file.getNext();
		temp_rank = location.rank;
		// to bottom right
		while (file != null) {
			temp_rank -= 1;
			if (temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getNext();
		}

		file = location.file.getPrev();
		temp_rank = location.rank;
		// to top left
		while (file != null) {
			temp_rank += 1;
			if (temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getPrev();
		}

		return moves;
	}

	public String toString() {
		return "B";
	}

}
