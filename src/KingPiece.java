
import java.util.ArrayList;

public class KingPiece extends Piece {

	KingPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> valid_moves() {
		ArrayList<Location> moves = new ArrayList<Location>();
		File file_minus_one = location.file.getPrev();
		File file_plus_one = location.file.getNext();
		
		int rank_plus_one = location.rank + 1;
		int rank_minus_one = location.rank - 1;
		
		if(file_minus_one != null){
			if(rank_plus_one > 0 && rank_plus_one < 9)
				moves.add(new Location(file_minus_one, rank_plus_one));
			if(rank_minus_one > 0 && rank_minus_one < 8)
				moves.add(new Location(file_minus_one, rank_minus_one));
			moves.add(new Location(file_minus_one, location.rank));
		}
		
		if(file_plus_one != null){
			if(rank_plus_one > 0 && rank_plus_one < 9)
				moves.add(new Location(file_plus_one, rank_plus_one));
			if(rank_minus_one > 0 && rank_minus_one < 9)
				moves.add(new Location(file_plus_one, rank_minus_one));
			moves.add(new Location(file_plus_one, location.rank));
		}
		
		if(rank_plus_one > 0 && rank_plus_one < 9)
			moves.add(new Location(location.file, rank_plus_one));
		if(rank_minus_one > 0 && rank_minus_one < 9)
			moves.add(new Location(location.file, rank_minus_one));
		
		return moves;
	}
	
//	@Override
	public String toString(){
		return "K";
	}

}
