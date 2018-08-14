
import java.util.ArrayList;

public class KnightPiece extends Piece {

	KnightPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> valid_moves() {
		ArrayList<Location> moves = new ArrayList<Location>();
		int rank_plus_two = location.rank + 2;
		int rank_plus_one = location.rank + 1;
		int rank_minus_two = location.rank - 2;
		int rank_minus_one = location.rank - 1;
		
		File file_plus_one = location.file.getNext();
		File file_plus_two = file_plus_one.getNext();
		File file_minus_one = location.file.getPrev();
		File file_minus_two = file_minus_one.getPrev();
		
		if(file_minus_one != null){
			if(rank_minus_two > 0 && rank_minus_two < 9)
				moves.add(new Location(file_minus_one, rank_minus_two));
			if(rank_plus_two > 0 && rank_plus_two < 9)
				moves.add(new Location(file_minus_one, rank_plus_two));
		}
		
		if(file_minus_two != null){
			if(rank_plus_one > 0 && rank_plus_one < 9)
				moves.add(new Location(file_minus_two, rank_plus_one));
			if(rank_minus_one > 0 && rank_minus_one < 9)
				moves.add(new Location(file_minus_two, rank_minus_one));
		}
		
		if(file_plus_one != null){
			if(rank_minus_two > 0 && rank_minus_two < 9)
				moves.add(new Location(file_plus_one, rank_minus_two));
			if(rank_plus_two > 0 && rank_plus_two < 9)
				moves.add(new Location(file_plus_one, rank_plus_two));
		}
		
		if(file_plus_two != null){
			if(rank_plus_one > 0 && rank_plus_one < 9)
				moves.add(new Location(file_plus_two, rank_plus_one));
			if(rank_minus_one > 0 && rank_minus_one < 9)
				moves.add(new Location(file_plus_two, rank_minus_one));
		}
		
		
		return moves;
	}
	
	public String toString(){
		return "N";
	}

}
