
import java.util.ArrayList;

public class RookPiece extends Piece {

	RookPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> valid_moves() {
		ArrayList<Location> moves = new ArrayList<Location>();
		for(int i =1; i<= 8; i++){
			if(location.rank != i)
				moves.add(new Location(location.file, i));
		}
		File file = File.A;
		while(file != null){
			if(location.file != file)
				moves.add(new Location(file, location.rank));
			file = file.getNext();
		}
		return moves;
	}
	
	public String toString(){
		return "R";
	}

}
